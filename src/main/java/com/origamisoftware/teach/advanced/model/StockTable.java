package com.origamisoftware.teach.advanced.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Models the quotes table
 */
@Entity
@Table(name="quotes")
public class StockTable {

    private int id;
    private String symbol;
    private BigDecimal price;
    private Calendar time;

    /**
     * Primary Key - Unique ID for a particular row in the quotes table.
     *
     * @return an integer value
     */

    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the quotes table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the quotes symbol
     */
    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 256)
    public String getSymbol() {
        return symbol;
    }

    /**
     * Specify the stock symbol
     * @param symbol a String value
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return the stock price
     */
    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true, length = 256)
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Specify the stock price
     * @param price a Big Decimal
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     *
     * @return the stock time
     */
    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public Calendar getTime() {
        return time;
    }

    /**
     * Specify the stock time
     * @param time  the time the person was born.
     */
    public void setTime(Calendar time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockTable stock = (StockTable) o;

        if (id != stock.id) return false;
        if (time != null ? !time.equals(stock.time) : stock.time != null)
            return false;
        if (symbol != null ? !symbol.equals(stock.symbol) : stock.symbol != null)
            return false;
        if (price != null ? !price.equals(stock.price) : stock.price != null)
            return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (symbol != null ? symbol.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Stock{" +
                " id=" + id +  '\'' +
                " symbol=" + symbol + '\'' +
                ", price=" + price + '\'' +
                ", time=" + time +
                '}';
    }
}
