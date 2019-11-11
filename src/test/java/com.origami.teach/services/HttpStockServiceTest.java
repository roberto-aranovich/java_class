package com.origami.teach.services;

import com.origami.teach.model.StockQuote;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class HttpStockServiceTest {


    @Test
    public void testGetQuote() throws Exception {
        StockService stockService = ServiceFactory.getHttpServiceInstance();
        String symbol = "MMM";
        StockQuote stockQuote = stockService.getQuote(symbol);
        System.out.println( stockQuote.toString() );
        assertNotNull("Verify we can get a stock quote from the web", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testGetQuote2() throws Exception {
        StockService stockService = ServiceFactory.getHttpServiceInstance();
        String symbol = "MMM";
        String from = "2018/01/01";
        String until = "2019/01/01";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendarFrom = Calendar.getInstance();
        Calendar calendarUntil = Calendar.getInstance();
        calendarFrom.setTime(simpleDateFormat.parse(from));
        calendarUntil.setTime(simpleDateFormat.parse(until));
        List<StockQuote> stockQuotes = stockService.getQuote(symbol, calendarFrom, calendarUntil);
        for(StockQuote quote : stockQuotes){
            System.out.println( quote.toString() );
        }
        assertNotNull("Verify we can get a stock quote list from the web", stockQuotes);
        assertEquals("Make sure the symbols match", symbol, stockQuotes.get(0).getSymbol());
    }

}
