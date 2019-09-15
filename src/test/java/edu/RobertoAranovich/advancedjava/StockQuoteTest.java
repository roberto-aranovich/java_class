package edu.RobertoAranovich.advancedjava;

import org.junit.Test;
import java.math.BigDecimal;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * JUnit test for StockQuote class.
 *
 * @author Roberto Aranovich
 */

public class StockQuoteTest {

    @Test
    public void testGetStockSymbolPositive() {
        BigDecimal price = new BigDecimal(171.44);
        String symbol = "MMM";
        StockQuote quote = new StockQuote(price, symbol);
        assertTrue("Testing getStockSymbol", quote.getStockSymbol().equals(symbol));
    }

    @Test
    public void testGetStockSymbolNegative() {
        BigDecimal price = new BigDecimal(171.44);
        String symbol = "MMM";
        StockQuote quote = new StockQuote(price, symbol);
        assertFalse("Testing getStockSymbol doesn't return null", quote.getStockSymbol() == null);
    }

    @Test
    public void testGetStockPricePositive() {
        BigDecimal price = new BigDecimal(171.44);
        String symbol = "MMM";
        StockQuote quote = new StockQuote(price, symbol);
        assertTrue("Testing getStockPrice", quote.getStockPrice().equals(price));
    }

    @Test
    public void testGetStockPriceNegative() {
        BigDecimal price = new BigDecimal(171.44);
        String symbol = "MMM";
        StockQuote quote = new StockQuote(price, symbol);
        assertFalse("Testing getStockPrice doesn't return null", quote.getStockPrice() == null);
    }
}
