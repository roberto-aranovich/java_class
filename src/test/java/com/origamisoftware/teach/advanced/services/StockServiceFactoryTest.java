package com.origamisoftware.teach.advanced.services;

import org.junit.Test;

import org.junit.Before;

import static org.junit.Assert.assertNotNull;

import com.origamisoftware.teach.advanced.util.DatabaseUtils;


/**
 * JUnit test for <CODE>StockServiceFactory</CODE>
 */
public class StockServiceFactoryTest {
    
    @Before
    public void setup() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Test
    public void testGetInstance() {
        StockService stockService = ServiceFactory.getStockServiceInstance();
        assertNotNull(stockService);
    }
}
