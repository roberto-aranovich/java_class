package edu.RobertoAranovich.advancedjava;

import org.junit.Test;

import static edu.RobertoAranovich.advancedjava.StockServiceFactory.buildStockService;
import static edu.RobertoAranovich.advancedjava.StockServiceType.BASIC;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test for StockServiceFactory class.
 *
 * @author Roberto Aranovich
 */

public class StockServiceFactoryTest {

    @Test
    public void testBuildStockServicePositive() {

        StockService stockService = buildStockService(BASIC);
        boolean isStockService = false;
        if (stockService instanceof StockService) {
            isStockService = true;
        }
        assertTrue("Testing that buildStockService returns an implementation of StockService", isStockService);
    }

    @Test
    public void testBuildStockServiceNegative() {
        StockService stockService = buildStockService(BASIC);
        assertFalse("Testing that buildStockService doesn't return null", stockService == null);
    }

}