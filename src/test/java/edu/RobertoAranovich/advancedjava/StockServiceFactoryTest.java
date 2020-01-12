package edu.RobertoAranovich.advancedjava;

import org.junit.Test;

import java.text.ParseException;

import static edu.RobertoAranovich.advancedjava.StockServiceFactory.buildStockService;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test for StockServiceFactory class.
 *
 * @author Roberto Aranovich
 */

public class StockServiceFactoryTest {

    @Test
    public void testBuildStockServicePositive() throws ParseException {

        StockService stockService = buildStockService();
        boolean isStockService = false;
        if (stockService instanceof StockService) {
            isStockService = true;
        }
        assertTrue( "Testing that buildStockService returns an implementation of StockService", isStockService );
    }

    @Test
    public void testBuildStockServiceNegative() throws ParseException {
        StockService stockService = buildStockService();
        assertFalse( "Testing that buildStockService doesn't return null", stockService == null );
    }

}