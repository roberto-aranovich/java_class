package com.origami.teach.services;

import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>StockServiceFactory</CODE>
 */
public class StockServiceFactoryTest {

    @Test
    public void testGetInstance() throws ParseException {
        StockService stockService = ServiceFactory.getDatabaseStockService();
        assertNotNull(stockService);
    }

    @Test
    public void testHttpInstance () {
        StockService stockService = ServiceFactory.getHttpServiceInstance();
        assertNotNull(stockService);
    }

}
