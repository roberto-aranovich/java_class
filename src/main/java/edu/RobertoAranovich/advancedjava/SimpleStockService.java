package edu.RobertoAranovich.advancedjava;

import java.math.BigDecimal;

public class SimpleStockService implements StockService {
    private BigDecimal price = new BigDecimal(171.44);

    public SimpleStockService(){};

    public StockQuote getQuote(String symbol){
        StockQuote quote = new StockQuote(price, symbol);
        return quote;
    }



}
