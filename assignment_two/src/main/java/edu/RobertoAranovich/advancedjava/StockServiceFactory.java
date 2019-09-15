package edu.RobertoAranovich.advancedjava;

/**
 * Implementation of StockServiceFactory class.
 *
 * @author Roberto Aranovich
 */

public class StockServiceFactory {

    /**
     * Implementation of getQuote method that returns a StockQuote with a hard coded price value.
     *
     * @param type an element from the StockServiceType enumeration.
     */
    public static StockService buildStockService(StockServiceType type) {
        StockService stockService = null;
        switch (type) {
            case BASIC:
                stockService = new BasicStockService();
                break;
        }
        return stockService;
    }
}
