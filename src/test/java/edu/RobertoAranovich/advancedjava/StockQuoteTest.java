package edu.RobertoAranovich.advancedjava;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test for StockQuote class.
 *
 * @author Roberto Aranovich
 */

public class StockQuoteTest {
    private SimpleDateFormat dateFormat = new SimpleDateFormat( "MM-dd-yyyy" );

    @Test
    public void testGetStockSymbolPositive() throws ParseException {
        BigDecimal price = new BigDecimal( 171.44 );
        String symbol = "MMM";
        Date date = dateFormat.parse( "11-11-2011" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        StockQuote quote = new StockQuote( price, symbol, calendar );
        assertTrue( "Testing getStockSymbol", quote.getStockSymbol().equals( symbol ) );
    }

    @Test
    public void testGetStockSymbolNegative() throws ParseException {
        BigDecimal price = new BigDecimal( 171.44 );
        String symbol = "MMM";
        Date date = dateFormat.parse( "11-11-2011" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        StockQuote quote = new StockQuote( price, symbol, calendar );
        assertFalse( "Testing getStockSymbol doesn't return null", quote.getStockSymbol() == null );
    }

    @Test
    public void testGetStockPricePositive() throws ParseException {
        BigDecimal price = new BigDecimal( 171.44 );
        String symbol = "MMM";
        Date date = dateFormat.parse( "11-11-2011" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        StockQuote quote = new StockQuote( price, symbol, calendar );
        assertTrue( "Testing getStockPrice", quote.getStockPrice().equals( price ) );
    }

    @Test
    public void testGetStockPriceNegative() throws ParseException {
        BigDecimal price = new BigDecimal( 171.44 );
        String symbol = "MMM";
        Date date = dateFormat.parse( "11-11-2011" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        StockQuote quote = new StockQuote( price, symbol, calendar );
        assertFalse( "Testing getStockPrice doesn't return null", quote.getStockPrice() == null );
    }

    @Test
    public void testGetDateRecordedPositive() throws ParseException {
        BigDecimal price = new BigDecimal( 171.44 );
        String symbol = "MMM";
        Date date = dateFormat.parse( "11-11-2011" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        StockQuote quote = new StockQuote( price, symbol, calendar );
        assertTrue( "Testing getDateRecorded", quote.getDateRecorded().equals( calendar ) );
    }

    @Test
    public void testGetDateRecordedNegative() throws ParseException {
        BigDecimal price = new BigDecimal( 171.44 );
        String symbol = "MMM";
        Date date = dateFormat.parse( "11-11-2011" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        StockQuote quote = new StockQuote( price, symbol, calendar );
        assertFalse( "Testing getDateRecorded doesn't return null", quote.getDateRecorded() == null );
    }

}
