package com.origamisoftware.teach.advanced.apps.stockquote;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.model.StockTable;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;
import com.origamisoftware.teach.advanced.services.StockServiceException;
import com.origamisoftware.teach.advanced.xml.Stock;
import com.origamisoftware.teach.advanced.xml.Stocks;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A basic app that shows how to marshall and unmarshal XML instances.
 */
public class BasicJAXBExample<line> {

    public BasicJAXBExample() throws JAXBException {
    }

    public static void main(String[] args) throws JAXBException, IOException, ParseException, StockServiceException, org.json.simple.parser.ParseException {

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

        // here is how to go from Java to XML
        JAXBContext context = JAXBContext.newInstance(Stocks.class);
        Marshaller marshaller = context.createMarshaller();
        //for pretty-print XML in JAXB
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(stocks, System.out);

        StockService stockService = ServiceFactory.getStockServiceInstance();

        int index = 101;
        for( Stock  quote : stocks.getStocks()){
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

        Date from = dateFormat.parse("2000-01-01 00:00:00");
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );

        Date until = dateFormat.parse("2019-01-01 00:00:00");
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( until );

        List<StockQuote> quotes = stockService.getQuote("GOOG", calendarFrom, calendarUntil );
        for(StockQuote quote : quotes) {
            System.out.println( quote.toString() );
        }
    }
}
