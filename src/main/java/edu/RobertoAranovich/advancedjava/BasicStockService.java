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
    private SimpleDateFormat dateFormat = new SimpleDateFormat( "MM-dd-yyyy HH:mm" );

    /**
     * Implementation of getQuote method that returns a
     * StockQuote object.
     * It uses a hard coded list of StockQuotes as "database".
     *
     * @param symbol a String representing the Stock symbol.
     */
    public StockQuote getQuote(String symbol) throws ParseException {
        BigDecimal price = new BigDecimal( 170.00 );
        Date date = dateFormat.parse( "09-16-2019 00:00" );
        Calendar calendar = Calendar.getInstance();
        calendar.setTime( date );
        StockQuote quote = new StockQuote( price, symbol, calendar );
        return quote;
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

    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws ParseException {
        List<StockQuote> database = new ArrayList<>();
        BigDecimal price1 = new BigDecimal( 170.00 );
        Date date1 = dateFormat.parse( "09-16-2019 00:00" );
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime( date1 );
        StockQuote quote1 = new StockQuote( price1, symbol, calendar1 );
        database.add( quote1 );

        BigDecimal price2 = new BigDecimal( 171.00 );
        Date date2 = dateFormat.parse( "09-19-2019 00:00" );
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime( date2 );
        StockQuote quote2 = new StockQuote( price2, symbol, calendar2 );
        database.add( quote2 );

        BigDecimal price3 = new BigDecimal( 172.00 );
        Date date3 = dateFormat.parse( "09-18-2019 00:00" );
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime( date3 );
        StockQuote quote3 = new StockQuote( price3, symbol, calendar3 );
        database.add( quote3 );

        BigDecimal price4 = new BigDecimal( 173.00 );
        Date date4 = dateFormat.parse( "09-19-2019 00:00" );
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime( date4 );
        StockQuote quote4 = new StockQuote( price4, symbol, calendar4 );
        database.add( quote4 );

        BigDecimal price5 = new BigDecimal( 174.00 );
        Date date5 = dateFormat.parse( "09-20-2019 00:00" );
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime( date5 );
        StockQuote quote5 = new StockQuote( price5, symbol, calendar5 );
        database.add( quote5 );

        Calendar date = from;
        List<StockQuote> quotes = new ArrayList<>();

        for (StockQuote quote : database) {
            if (quote.getDateRecorded().equals( date )) {
                quotes.add( quote );
                date.add( Calendar.DAY_OF_YEAR, 1 );
                if (date.after( until )) {
                    break;
                }
            }
        }

        return quotes;
    }

    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws ParseException {

        List<StockQuote> database = new ArrayList<>();
        BigDecimal price1 = new BigDecimal( 170.00 );
        Date date1 = dateFormat.parse( "09-16-2019 00:00" );
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime( date1 );
        StockQuote quote1 = new StockQuote( price1, symbol, calendar1 );
        database.add( quote1 );

        BigDecimal price1b = new BigDecimal( 170.50 );
        Date date1b = dateFormat.parse( "09-16-2019 12:00" );
        Calendar calendar1b = Calendar.getInstance();
        calendar1b.setTime( date1b );
        StockQuote quote1b = new StockQuote( price1b, symbol, calendar1b );
        database.add( quote1b );

        BigDecimal price2 = new BigDecimal( 171.00 );
        Date date2 = dateFormat.parse( "09-17-2019 00:00" );
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime( date2 );
        StockQuote quote2 = new StockQuote( price2, symbol, calendar2 );
        database.add( quote2 );

        BigDecimal price2b = new BigDecimal( 171.50 );
        Date date2b = dateFormat.parse( "09-17-2019 12:00" );
        Calendar calendar2b = Calendar.getInstance();
        calendar2b.setTime( date2b );
        StockQuote quote2b = new StockQuote( price2b, symbol, calendar2b );
        database.add( quote2b );

        BigDecimal price3 = new BigDecimal( 172.00 );
        Date date3 = dateFormat.parse( "09-18-2019 00:00" );
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime( date3 );
        StockQuote quote3 = new StockQuote( price3, symbol, calendar3 );
        database.add( quote3 );

        BigDecimal price3b = new BigDecimal( 172.50 );
        Date date3b = dateFormat.parse( "09-18-2019 12:00" );
        Calendar calendar3b = Calendar.getInstance();
        calendar3b.setTime( date3b );
        StockQuote quote3b = new StockQuote( price3b, symbol, calendar3b );
        database.add( quote3b );

        BigDecimal price4 = new BigDecimal( 173.00 );
        Date date4 = dateFormat.parse( "09-19-2019 00:00" );
        Calendar calendar4 = Calendar.getInstance();
        calendar4.setTime( date4 );
        StockQuote quote4 = new StockQuote( price4, symbol, calendar4 );
        database.add( quote4 );

        BigDecimal price4b = new BigDecimal( 173.50 );
        Date date4b = dateFormat.parse( "09-19-2019 12:00" );
        Calendar calendar4b = Calendar.getInstance();
        calendar4b.setTime( date4b );
        StockQuote quote4b = new StockQuote( price4b, symbol, calendar4b );
        database.add( quote4b );

        BigDecimal price5 = new BigDecimal( 174.00 );
        Date date5 = dateFormat.parse( "09-20-2019 00:00" );
        Calendar calendar5 = Calendar.getInstance();
        calendar5.setTime( date5 );
        StockQuote quote5 = new StockQuote( price5, symbol, calendar5 );
        database.add( quote5 );

        BigDecimal price5b = new BigDecimal( 174.50 );
        Date date5b = dateFormat.parse( "09-20-2019 12:00" );
        Calendar calendar5b = Calendar.getInstance();
        calendar5b.setTime( date5b );
        StockQuote quote5b = new StockQuote( price5b, symbol, calendar5b );
        database.add( quote5b );

        Calendar date = from;
        List<StockQuote> quotes = new ArrayList<>();
        for (StockQuote quote : database) {
            if (quote.getDateRecorded().equals( date )) {
                quotes.add( quote );
                switch (interval) {
                    case ONE_HOUR:
                        date.add( Calendar.HOUR_OF_DAY, 1 );
                        break;
                    case TWELVE_HOURS:
                        date.add( Calendar.HOUR_OF_DAY, 12 );
                        break;
                    case ONE_DAY:
                        date.add( Calendar.DAY_OF_YEAR, 1 );
                        break;
                    default:
                        throw new IllegalArgumentException( "A valid interval value should be provided" );
                }
                if (date.after( until )) {
                    break;
                }
            }
        }
        return quotes;
    }
}
