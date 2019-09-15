package edu.RobertoAranovich.advancedjava;

import java.math.BigDecimal;

/**
 * Implementation of StockQuote class.
 * It is a simplified version of the implementation provided in class.
 */

public class StockQuote {

    private String stockSymbol;
    private BigDecimal stockPrice;

    /**
     * Create a new  StockData instance
     *
     * @param stockPrice  the price of the stock for the provided date
     * @param stockSymbol the stock symbol e.g. MMM (for 3M)
     */
    public StockQuote(BigDecimal stockPrice, String stockSymbol) {
        this.stockPrice = stockPrice;
        this.stockSymbol = stockSymbol;
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

}
