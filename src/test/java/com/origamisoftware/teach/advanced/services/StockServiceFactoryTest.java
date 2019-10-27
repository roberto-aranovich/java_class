package com.origamisoftware.teach.advanced.services;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>StockServiceFactory</CODE>
 */
public class StockServiceFactoryTest {

    @Test
    public void testGetInstance() {
        StockService stockService = ServiceFactory.getStockServiceInstance();
        assertNotNull(stockService);
    }

    @Test
    public void testSimpleInstance () {
        StockService stockService = ServiceFactory.getBasicServiceInstance();
        assertNotNull(stockService);
    }

    @Test
    public void testHttpInstance () {
        StockService stockService = ServiceFactory.getHttpServiceInstance();
        assertNotNull(stockService);
    }

    @Test
    public void testPersonInstance () {
        PersonService personService = ServiceFactory.getPersonServiceInstance();
        assertNotNull(personService);
    }


}
