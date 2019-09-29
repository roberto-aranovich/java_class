package edu.RobertoAranovich.advancedjava;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

/**
 * This interface describes an API for getting stock data.
 */
public interface StockService {

    /**
     * Get a stock quotes for the provided symbol and date.
     *
     * @param symbol the stock symbol to search for
     * @return a StockQuote instance.
     */

    StockQuote getQuote(String symbol) throws ParseException;


    /**
     * Get a historical list of stock quotes for the provided symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances.
     * One for each day in the range specified.
     */

    List<StockQuote> getQuote(String symbol, Calendar from,
                              Calendar until) throws ParseException;

    /**
     * Get a historical list of stock quotes for the provide symbol
     * This method will return one StockQuote per interval specified.
     *
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @param interval ­ the number of StockQuotes to get. E.g. if Interval.DAILY was
     *                 specified
     *                 one StockQuote per day will be returned.
     * @return a list of StockQuote instances. One for each day in the range specified.
     */
    List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) throws ParseException;
}
