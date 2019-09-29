package edu.RobertoAranovich.advancedjava;

import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * JUnit test for StockQuoteApplication class.
 *
 * @author Roberto Aranovich
 */

public class StockQuoteApplicationTest {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat( "MM-dd-yyyy" );
    private static ArrayList<StockQuote> database = new ArrayList<>();

    @Test
    public void testDateRecordedOutput() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        populateDatabase();
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( database ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuote( symbol, calendarFrom, calendarUntil );
        assertTrue( "Testing dateRecorded value in first element of StockQuote list", stockQuoteList.get( 0 ).getDateRecorded().equals( calendarFrom ) );
    }

    @Test
    public void testStockSymbolOutput() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        populateDatabase();
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( database ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuote( symbol, calendarFrom, calendarUntil );
        assertTrue( "Testing symbol value in first element of StockQuote list", stockQuoteList.get( 0 ).getStockSymbol().equals( symbol ) );
    }

    @Test
    public void testStockPriceOutput() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        BigDecimal price = new BigDecimal( 170.00 );
        populateDatabase();
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( database ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuote( symbol, calendarFrom, calendarUntil );
        assertTrue( "Testing price value in first element of StockQuote list", stockQuoteList.get( 0 ).getStockPrice().equals( price ) );
    }

    @Test
    public void testGetQuoteNegative() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( until );
        populateDatabase();
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( database ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuote( symbol, calendarFrom, calendarUntil );
        assertFalse( "Testing that first element in StockQuote list is not null", stockQuoteList.get( 0 ) == null );
    }

    @Test
    public void testDateRecordedOutput2() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        Interval interval = Interval.TWELVE_HOURS;
        populateDatabase();
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ), any( Calendar.class ), any( Interval.class ) ) ).thenReturn( new ArrayList<StockQuote>( database ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuote( symbol, calendarFrom, calendarUntil, interval );
        assertTrue( "Testing dateRecorded value in second element of StockQuote list", stockQuoteList.get( 1 ).getDateRecorded().equals( calendarFrom ) );
    }

    @Test
    public void testStockSymbolOutput2() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        populateDatabase();
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( database ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuote( symbol, calendarFrom, calendarUntil );
        assertTrue( "Testing symbol value in first element of StockQuote list", stockQuoteList.get( 0 ).getStockSymbol().equals( symbol ) );
    }

    @Test
    public void testStockPriceOutput2() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        BigDecimal price = new BigDecimal( 170.00 );
        populateDatabase();
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( database ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuote( symbol, calendarFrom, calendarUntil );
        assertTrue( "Testing price value in first element of StockQuote list", stockQuoteList.get( 0 ).getStockPrice().equals( price ) );
    }

    @Test
    public void testGetQuoteNegative2() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( until );
        populateDatabase();
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( database ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuote( symbol, calendarFrom, calendarUntil );
        assertFalse( "Testing that first element in StockQuote list is not null", stockQuoteList.get( 0 ) == null );

    }

    public void populateDatabase() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );

        String symbol = "MMM";

        BigDecimal price1 = new BigDecimal( 170.00 );
        Date date1 = dateFormat.parse( "09-16-2019 00:00" );
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime( date1 );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price1, symbol, calendar1 ) );
        StockQuote quote1 = basicStockServiceMock.getQuote( symbol );
        database.add( quote1 );

        BigDecimal price1b = new BigDecimal( 170.50 );
        Date date1b = dateFormat.parse( "09-16-2019 12:00" );
        Calendar calendar1b = Calendar.getInstance();
        calendar1b.setTime( date1b );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price1b, symbol, calendar1b ) );
        StockQuote quote1b = basicStockServiceMock.getQuote( symbol );
        database.add( quote1b );

        BigDecimal price2 = new BigDecimal( 171.00 );
        Date date2 = dateFormat.parse( "09-17-2019 00:00" );
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime( date2 );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price2, symbol, calendar2 ) );
        StockQuote quote2 = basicStockServiceMock.getQuote( symbol );
        database.add( quote2 );

        BigDecimal price2b = new BigDecimal( 171.50 );
        Date date2b = dateFormat.parse( "09-17-2019 12:00" );
        Calendar calendar2b = Calendar.getInstance();
        calendar2b.setTime( date2b );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price2b, symbol, calendar2b ) );
        StockQuote quote2b = basicStockServiceMock.getQuote( symbol );
        database.add( quote2b );

        BigDecimal price3 = new BigDecimal( 172.00 );
        Date date3 = dateFormat.parse( "09-18-2019 00:00" );
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime( date3 );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price3, symbol, calendar3 ) );
        StockQuote quote3 = basicStockServiceMock.getQuote( symbol );
        database.add( quote3 );

        BigDecimal price3b = new BigDecimal( 172.50 );
        Date date3b = dateFormat.parse( "09-18-2019 12:00" );
        Calendar calendar3b = Calendar.getInstance();
        calendar3.setTime( date3b );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price3b, symbol, calendar3b ) );
        StockQuote quote3b = basicStockServiceMock.getQuote( symbol );
        database.add( quote3b );

        BigDecimal price4 = new BigDecimal( 173.00 );
        Date date4 = dateFormat.parse( "09-19-2019 00:00" );
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime( date4 );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price4, symbol, calendar4 ) );
        StockQuote quote4 = basicStockServiceMock.getQuote( symbol );
        database.add( quote4 );

        BigDecimal price4b = new BigDecimal( 173.50 );
        Date date4b = dateFormat.parse( "09-19-2019 12:00" );
        Calendar calendar4b = Calendar.getInstance();
        calendar4b.setTime( date4b );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price4b, symbol, calendar4b ) );
        StockQuote quote4b = basicStockServiceMock.getQuote( symbol );
        database.add( quote4b );

        BigDecimal price5 = new BigDecimal( 174.00 );
        Date date5 = dateFormat.parse( "09-20-2019 00:00" );
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime( date5 );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price5, symbol, calendar5 ) );
        StockQuote quote5 = basicStockServiceMock.getQuote( symbol );
        database.add( quote5 );

        BigDecimal price5b = new BigDecimal( 174.50 );
        Date date5b = dateFormat.parse( "09-20-2019 12:00" );
        Calendar calendar5b = Calendar.getInstance();
        calendar5b.setTime( date5b );
        when( basicStockServiceMock.getQuote( any( String.class ) ) ).thenReturn( new StockQuote( price5b, symbol, calendar5b ) );
        StockQuote quote5b = basicStockServiceMock.getQuote( symbol );
        database.add( quote5b );
    }

}
