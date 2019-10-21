package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.apps.stockquote.BasicStockQuoteApplication;
import com.origamisoftware.teach.advanced.model.StockQuote;
import org.junit.Test;
import org.junit.Before;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.origamisoftware.teach.advanced.util.DatabaseUtils;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {

    private BasicStockQuoteApplication basicStockQuoteApplication;
    private StockService stockServiceMock;
    
      @Before
    public void setup() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }


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




}
