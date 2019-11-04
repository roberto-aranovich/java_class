package com.origami.teach.model;

/**
 * This class used for processing form data.
 *
 */
public class StockRequest {
    private String symbol;
    private String from;
    private String until;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    public void processData() {
        System.out.println("going to process data");
    }

    public boolean validateData() {

        if ((this.symbol == null) || (this.from == null) || (this.until == null))
            return false;

        return true;

    }
}