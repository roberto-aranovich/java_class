package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.apps.stockquote.BasicStockQuoteApplication;
import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.model.StockTable;
import com.origamisoftware.teach.advanced.xml.Stock;
import com.origamisoftware.teach.advanced.xml.Stocks;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {

    private BasicStockQuoteApplication basicStockQuoteApplication;
    private StockService stockServiceMock;

    @Test
    public void testGetQuote() throws Exception {
        //DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);

        DatabaseStockService databaseStockService = new DatabaseStockService();
        String symbol = "APPL";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        System.out.println( stockQuote.toString() );
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testGetQuote2() throws Exception {
        //DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);

        DatabaseStockService databaseStockService = new DatabaseStockService();
        String symbol = "GOOG";
        String from = "2000/01/01";
        String until = "2018/12/31";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendarFrom = Calendar.getInstance();
        Calendar calendarUntil = Calendar.getInstance();
        calendarFrom.setTime(simpleDateFormat.parse(from));
        calendarUntil.setTime(simpleDateFormat.parse(until));
        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, calendarFrom, calendarUntil);
        for(StockQuote quote : stockQuotes){
            System.out.println( quote.toString() );
        }
        assertNotNull("Verify we can get a stock quote list from the db", stockQuotes);
        assertEquals("Make sure the symbols match", symbol, stockQuotes.get(0).getSymbol());
    }

    @Test
    public void testAddOrUpdateQuote() throws JAXBException, IOException, ParseException, StockServiceException {
        try{
            StockService stockService = ServiceFactory.getStockServiceInstance();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            File stocksXmlFile = new File(".\\src\\main\\resources\\xml\\stock_info.xml");
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(stocksXmlFile));

            String stocksXmlInstance = "";

            String line;
            while ((line = br.readLine()) != null) {
                stocksXmlInstance = stocksXmlInstance + line + "\n";
            }

            // here is how to go from XML to Java
            JAXBContext jaxbContext = JAXBContext.newInstance( Stocks.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Stocks stocks = (Stocks) unmarshaller.unmarshal(new StringReader(stocksXmlInstance));
            System.out.println(stocks.toString());
            for( Stock  stock : stocks.getStocks()){
                System.out.println(stock.toString());
            }

            int index = 101;
            for( Stock quote : stocks.getStocks()){
                StockTable quoteTable = new StockTable();
                quoteTable.setId( index );
                quoteTable.setSymbol( quote.getSymbol() );
                quoteTable.setPrice( new BigDecimal(Float.parseFloat(quote.getPrice())) );
                Calendar quoteCalendar = Calendar.getInstance();
                quoteCalendar.setTime(dateFormat.parse(quote.getTime()));
                quoteTable.setTime(quoteCalendar);
                stockService.addOrUpdateQuote( quoteTable );
                index++;
            }
        }
        catch(Exception e){
            Assert.fail("addOrUpdateQuote fails with exception: " + e);
        }
    }

}
