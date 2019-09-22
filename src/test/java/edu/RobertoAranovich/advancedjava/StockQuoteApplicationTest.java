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
    private static ArrayList<StockQuote> stockQuoteList = new ArrayList<>();

    @Test
    public void testDateRecordedOutput() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        populateList();
        when( basicStockServiceMock.getQuotes( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( stockQuoteList ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuotes( symbol, calendarFrom, calendarUntil );
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
        populateList();
        when( basicStockServiceMock.getQuotes( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( stockQuoteList ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuotes( symbol, calendarFrom, calendarUntil );
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
        populateList();
        when( basicStockServiceMock.getQuotes( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( stockQuoteList ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuotes( symbol, calendarFrom, calendarUntil );
        assertTrue( "Testing price value in first element of StockQuote list", stockQuoteList.get( 0 ).getStockPrice().equals( price ) );
    }

    @Test
    public void testGetQuotesNegative() throws ParseException {
        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        String symbol = "MMM";
        Date from = dateFormat.parse( "09-16-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( until );
        populateList();
        when( basicStockServiceMock.getQuotes( any( String.class ), any( Calendar.class ), any( Calendar.class ) ) ).thenReturn( new ArrayList<StockQuote>( stockQuoteList ) );
        List<StockQuote> stockQuoteList = basicStockServiceMock.getQuotes( symbol, calendarFrom, calendarUntil );
        assertFalse( "Testing that first element in StockQuote list is not null", stockQuoteList.get( 0 ) == null );
    }

    public static void populateList() throws ParseException {

        BasicStockService basicStockServiceMock = Mockito.mock( BasicStockService.class );
        StockQuote stockQuoteMock = Mockito.mock( StockQuote.class );

        String symbol = "MMM";

        BigDecimal price1 = new BigDecimal( 170.00 );
        Date date1 = dateFormat.parse( "09-16-2019" );
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime( date1 );
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ) ) ).thenReturn( new StockQuote( price1, symbol, calendar1 ) );
        StockQuote quote1 = basicStockServiceMock.getQuote( symbol, calendar1 );

        BigDecimal price2 = new BigDecimal( 171.00 );
        Date date2 = dateFormat.parse( "09-17-2019" );
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime( date2 );
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ) ) ).thenReturn( new StockQuote( price2, symbol, calendar2 ) );
        StockQuote quote2 = basicStockServiceMock.getQuote( symbol, calendar2 );

        BigDecimal price3 = new BigDecimal( 172.00 );
        Date date3 = dateFormat.parse( "09-18-2019" );
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime( date3 );
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ) ) ).thenReturn( new StockQuote( price3, symbol, calendar3 ) );
        StockQuote quote3 = basicStockServiceMock.getQuote( symbol, calendar3 );

        BigDecimal price4 = new BigDecimal( 173.00 );
        Date date4 = dateFormat.parse( "09-19-2019" );
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime( date4 );
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ) ) ).thenReturn( new StockQuote( price4, symbol, calendar4 ) );
        StockQuote quote4 = basicStockServiceMock.getQuote( symbol, calendar4 );

        BigDecimal price5 = new BigDecimal( 174.00 );
        Date date5 = dateFormat.parse( "09-20-2019" );
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime( date5 );
        when( basicStockServiceMock.getQuote( any( String.class ), any( Calendar.class ) ) ).thenReturn( new StockQuote( price5, symbol, calendar5 ) );
        StockQuote quote5 = basicStockServiceMock.getQuote( symbol, calendar5 );

        stockQuoteList.add( quote1 );
        stockQuoteList.add( quote2 );
        stockQuoteList.add( quote3 );
        stockQuoteList.add( quote4 );
        stockQuoteList.add( quote5 );
    }
}
