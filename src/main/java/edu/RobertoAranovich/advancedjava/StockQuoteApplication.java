package edu.RobertoAranovich.advancedjava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static edu.RobertoAranovich.advancedjava.StockServiceFactory.buildStockService;

/**
 * Class to display the output of the StockService.
 *
 * @author: Roberto Aranovich
 */

public class StockQuoteApplication {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat( "MM-dd-yyyy HH:mm" );
        Date from = dateFormat.parse( "09-16-2019 00:00" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019 00:00" );
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( until );
        StockService stockService = buildStockService();

        StockQuote aQuote = stockService.getQuote( "MMM" );
        System.out.println( "Retrieving a single StockQuote:" );
        System.out.println( "Symbol: " + aQuote.getStockSymbol() + " Date: "
                + aQuote.getDateRecorded().getTime()
                + " Price: " + aQuote.getStockPrice() );
        System.out.println();

        List<StockQuote> quotes = stockService.getQuote( "MMM", calendarFrom, calendarUntil );
        System.out.println( "Retrieving a list of StockQuote objects" );
        for (StockQuote quote : quotes) {
            System.out.println( "Symbol: " + quote.getStockSymbol() + " Date: "
                    + quote.getDateRecorded().getTime()
                    + " Price: " + quote.getStockPrice() );
        }
        System.out.println();

        calendarFrom.setTime( from );
        List<StockQuote> quotes2 = stockService.getQuote( "MMM", calendarFrom, calendarUntil, Interval.TWELVE_HOURS );
        System.out.println( "Retrieving a list of StockQuote objects" );
        for (StockQuote quote2 : quotes2) {
            System.out.println( "Symbol: " + quote2.getStockSymbol() + " Date: "
                    + quote2.getDateRecorded().getTime()
                    + " Price: " + quote2.getStockPrice() );
        }
    }
}
