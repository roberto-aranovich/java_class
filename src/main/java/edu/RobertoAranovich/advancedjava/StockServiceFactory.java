package edu.RobertoAranovich.advancedjava;

public class StockServiceFactory {
    public static StockService buildStockService(StockServiceType type) {
        StockService stockService = null;
        switch (type) {
            case SIMPLE:
                stockService = new SimpleStockService();
                break;
        }
        return stockService;
    }
}
