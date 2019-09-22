package edu.RobertoAranovich.advancedjava;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Basic implementation of StockService interface.
 *
 * @author Roberto Aranovich
 */

public class BasicStockService implements StockService {
    private SimpleDateFormat dateFormat = new SimpleDateFormat( "MM-dd-yyyy" );
    private ArrayList<StockQuote> stockQuoteList = new ArrayList<>();

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
            if ((quote.getStockSymbol().equals( symbol ))
                    && (quote.getDateRecorded().equals( date ))) {
                return quote;
            }
        }
        return null;
    }

    /**
     * Implementation of getQuotes method that returns a list of
     * StockQuote objects for the specified date range.
     * It uses a hard coded list of StockQuotes as "database".
     *
     * @param symbol a String representing the Stock symbol.
     * @param from   a Calendar representing the beginning of the date range.
     * @param until  a Calendar representing the end of the date range.
     */

    public List<StockQuote> getQuotes(String symbol, Calendar from,
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

    public void populateList() throws ParseException {

        String symbol = "MMM";

        BigDecimal price1 = new BigDecimal( 170.00 );
        Date date1 = dateFormat.parse( "09-16-2019" );
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime( date1 );
        StockQuote quote1 = new StockQuote( price1, symbol, calendar1 );

        BigDecimal price2 = new BigDecimal( 171.00 );
        Date date2 = dateFormat.parse( "09-17-2019" );
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime( date2 );
        StockQuote quote2 = new StockQuote( price2, symbol, calendar2 );

        BigDecimal price3 = new BigDecimal( 172.00 );
        Date date3 = dateFormat.parse( "09-18-2019" );
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime( date3 );
        StockQuote quote3 = new StockQuote( price3, symbol, calendar3 );

        BigDecimal price4 = new BigDecimal( 173.00 );
        Date date4 = dateFormat.parse( "09-19-2019" );
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime( date4 );
        StockQuote quote4 = new StockQuote( price4, symbol, calendar4 );

        BigDecimal price5 = new BigDecimal( 174.00 );
        Date date5 = dateFormat.parse( "09-20-2019" );
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime( date5 );
        StockQuote quote5 = new StockQuote( price5, symbol, calendar5 );

        stockQuoteList.add( quote1 );
        stockQuoteList.add( quote2 );
        stockQuoteList.add( quote3 );
        stockQuoteList.add( quote4 );
        stockQuoteList.add( quote5 );
    }

}
