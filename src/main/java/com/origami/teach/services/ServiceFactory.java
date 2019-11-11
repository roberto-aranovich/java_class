package com.origami.teach.services;

import java.text.ParseException;

/**
 * A factory that returns a <CODE>StockService</CODE> instance.
 */
public class ServiceFactory {

    /**
     * Prevent instantiations
     */
    private ServiceFactory() {
    }

    /**
     * @return get a <CODE>StockService</CODE> instance
     */

    public static StockService getHttpServiceInstance() {
        return new HttpStockService();
    }

    public static StockService getBasicServiceInstance() throws ParseException {
        StockService stockService = new BasicStockService();
        return stockService;
    }

    public static StockService getDatabaseStockService() throws ParseException {
        StockService stockService = new DatabaseStockService();
        return stockService;
    }
}
