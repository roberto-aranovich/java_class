package edu.RobertoAranovich.advancedjava;

import java.text.ParseException;

/**
 * Implementation of StockServiceFactory class.
 *
 * @author Roberto Aranovich
 */

public class StockServiceFactory {

    /**
     * StockServiceFactory class that returns an implementation of StockService
     * depending of the arguments in the call.
     * At this point only a non argument call that returns an instance of
     * BasicStockService is implemented.
     */
    public static StockService buildStockService() throws ParseException {
        StockService stockService = new BasicStockService();
        return stockService;
    }
}
