package com.origamisoftware.teach.advanced.services;

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
    public static StockService getStockServiceInstance() {
        return new DatabaseStockService();
    }

    public static StockService getBasicServiceInstance() {
        return new SimpleStockService();
    }

    public static StockService getHttpServiceInstance() {
        return new HttpStockService();
    }

    public static PersonService getPersonServiceInstance() {
        return new DatabasePersonService();
    }

}
