package com.origami.teach.services;

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
}
