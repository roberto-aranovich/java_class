package edu.RobertoAranovich.advancedjava;

/**
 *  This interface describes an API for getting stock data.
 */
public interface StockService {
    /**
     * Return the <CODE>StockQuote</CODE> for the given symbol for the given date.
     * Used to get history data for the stock.
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  StockQuote instance
     */
    StockQuote getQuote(String symbol);
}
