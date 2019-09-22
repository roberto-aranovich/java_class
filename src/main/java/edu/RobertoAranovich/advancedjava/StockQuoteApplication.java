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
        SimpleDateFormat dateFormat = new SimpleDateFormat( "MM-dd-yyyy" );
        Date from = dateFormat.parse( "09-17-2019" );
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );
        Date until = dateFormat.parse( "09-19-2019" );
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( until );
        StockService stockService = buildStockService();

        stockService.populateList();
        StockQuote aQuote = stockService.getQuote( "MMM", calendarFrom );
        System.out.println( "Retrieving a single StockQuote:" );
        System.out.println( "Symbol: " + aQuote.getStockSymbol() + " Date: "
                + aQuote.getDateRecorded().getTime()
                + " Price: " + aQuote.getStockPrice() );
        System.out.println();
        List<StockQuote> quotes = stockService.getQuotes( "MMM", calendarFrom, calendarUntil );
        System.out.println( "Retrieving a list of StockQuote objects" );
        for (StockQuote quote : quotes) {
            System.out.println( "Symbol: " + quote.getStockSymbol() + " Date: "
                    + quote.getDateRecorded().getTime()
                    + " Price: " + quote.getStockPrice() );
        }
    }
}
