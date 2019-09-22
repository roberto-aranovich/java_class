package edu.RobertoAranovich.advancedjava;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Implementation of StockQuote class.
 * It is a simplified version of the implementation provided in class.
 */

public class StockQuote {

    private String stockSymbol;
    private BigDecimal stockPrice;
    private Calendar dateRecorded;

    /**
     * Create a new  StockData instance
     *
     * @param stockPrice   the price of the stock for the provided date
     * @param stockSymbol  the stock symbol e.g. MMM (for 3M)
     * @param dateRecorded the date the stock info was recorded.
     */
    public StockQuote(BigDecimal stockPrice, String stockSymbol, Calendar dateRecorded) {
        this.stockPrice = stockPrice;
        this.stockSymbol = stockSymbol;
        this.dateRecorded = dateRecorded;
    }

    /**
     * @return the symbol that represents the company.
     * e.g. MMM for 3M
     */
    public String getStockSymbol() {
        return stockSymbol;
    }

    /**
     * @return The price of one share of stock.
     */
    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    /**
     * @return the date of the stock price.
     */
    public Calendar getDateRecorded() {
        return dateRecorded;
    }

}
