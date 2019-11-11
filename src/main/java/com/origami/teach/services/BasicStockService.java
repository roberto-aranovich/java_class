package com.origami.teach.services;

import com.origami.teach.model.StockQuote;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Basic implementation of StockService interface.
 *
 * @author Roberto Aranovich
 */

public class BasicStockService implements StockService {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
    private static ArrayList<StockQuote> stockQuoteList = new ArrayList<>();

    /**
     * Implementation of getQuote method that returns a
     * StockQuote object.
     * It uses a hard coded list of StockQuotes as "database".
     *
     * @param symbol a String representing the Stock symbol.
     * @param date   a Calendar representing the date the stock was recorded at certain price.
     */
    public StockQuote getQuote(String symbol, Calendar date) throws ParseException {
        populateList();
        for (StockQuote quote : stockQuoteList) {
            if ((quote.getSymbol().equals( symbol ))
                    && (quote.getDate().equals( date ))) {
                return quote;
            }
        }
        return null;
    }

    public StockQuote getQuote(String symbol){return null;};

    /**
     * Implementation of getQuotes method that returns a list of
     * StockQuote objects for the specified date range.
     * It uses a hard coded list of StockQuotes as "database".
     *
     * @param symbol a String representing the Stock symbol.
     * @param from   a Calendar representing the beginning of the date range.
     * @param until  a Calendar representing the end of the date range.
     */

    public List<StockQuote> getQuote(String symbol, Calendar from,
                                      Calendar until) throws ParseException {
        Calendar date = from;
        List<StockQuote> quotes = new ArrayList<>();
        while (date.before( until )) {
            quotes.add( getQuote( symbol, date ) );
            date.add( Calendar.DAY_OF_YEAR, 1 );
        }
        return quotes;
    }

    /**
     * Method to populate a list of hard coded instances of StockQuote
     */

    public static void populateList() throws ParseException {

        String symbol = "MMM";

        BigDecimal price1 = new BigDecimal( 170.00 );
        Date date1 = dateFormat.parse( "2019-09-16" );
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime( date1 );
        StockQuote quote1 = new StockQuote( price1, date1, symbol);

        BigDecimal price2 = new BigDecimal( 171.00 );
        Date date2 = dateFormat.parse( "2019-09-17" );
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime( date2 );
        StockQuote quote2 = new StockQuote( price2, date2, symbol);

        BigDecimal price3 = new BigDecimal( 172.00 );
        Date date3 = dateFormat.parse( "2019-09-18" );
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime( date3 );
        StockQuote quote3 = new StockQuote( price3, date3, symbol );

        BigDecimal price4 = new BigDecimal( 173.00 );
        Date date4 = dateFormat.parse( "2019-09-19" );
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime( date4 );
        StockQuote quote4 = new StockQuote( price4, date4, symbol );

        BigDecimal price5 = new BigDecimal( 174.00 );
        Date date5 = dateFormat.parse( "2019-09-20" );
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime( date5 );
        StockQuote quote5 = new StockQuote( price5, date5, symbol );

        stockQuoteList.add( quote1 );
        stockQuoteList.add( quote2 );
        stockQuoteList.add( quote3 );
        stockQuoteList.add( quote4 );
        stockQuoteList.add( quote5 );
    }

}
