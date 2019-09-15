package edu.RobertoAranovich.advancedjava;

import org.junit.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

/**
 * JUnit test for BasicStockService class.
 *
 * @author Roberto Aranovich
 */

public class BasicStockServiceTest {

    @Test
    public void testBuildStockServicePositive() {
        BasicStockService basicStockServiceMock = Mockito.mock(BasicStockService.class);
        String symbol = "MMM";
        BigDecimal price = new BigDecimal(171.44);
        when(basicStockServiceMock.getQuote(any(String.class))).thenReturn(new StockQuote(price, symbol));
        StockQuote quote = basicStockServiceMock.getQuote(symbol);
        assertTrue("Testing getQuote returns a StockQuote object", quote.getClass().equals(StockQuote.class));
    }

    @Test
    public void testGetQuoteNegative() {
        BasicStockService basicStockServiceMock = Mockito.mock(BasicStockService.class);
        String symbol = "MMM";
        BigDecimal price = new BigDecimal(171.44);
        when(basicStockServiceMock.getQuote(any(String.class))).thenReturn(new StockQuote(price, symbol));
        StockQuote quote = basicStockServiceMock.getQuote(symbol);
        assertFalse("Testing getQuote doesn't return null", quote == null);
    }
}