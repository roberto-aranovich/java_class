package edu.RobertoAranovich.advancedjava;

import java.math.BigDecimal;

/**
 * Basic implementation of StockService interface.
 *
 * @author Roberto Aranovich
 */

public class BasicStockService implements StockService {
    private BigDecimal price = new BigDecimal(171.44);

    /**
     * Non argument constructor.
     */
    public BasicStockService() {
    }

    /**
     * Implementation of getQuote method that returns a StockQuote with a hard coded price value.
     *
     * @param symbol a String representing the Stock symbol.
     */
    public StockQuote getQuote(String symbol) {
        StockQuote quote = new StockQuote(price, symbol);
        return quote;
    }

}
