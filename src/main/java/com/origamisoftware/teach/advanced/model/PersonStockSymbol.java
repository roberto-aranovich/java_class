package com.origamisoftware.teach.advanced.model;

import javax.persistence.*;

/**
 * Models a table the combines person with a stock symbol.
 */
@Entity
@Table(name = "person_stocksymbol", catalog = "stocks")
public class PersonStockSymbol {
    private int id;
    private Person person;
    private String symbol;

    /**
     * Create a PersonStockSymbol that needs to be initialized
     */
    public PersonStockSymbol() {
        // this empty constructor is required by hibernate framework

    }

    /**
     * Create a valid PersonStockSymbol
     *
     * @param person the person interested in a stock
     * @param symbol  the stock the person is interested in
     */
    public PersonStockSymbol(Person person, String symbol) {
        setSymbol(symbol);
        setPerson(person);
    }

    /**
     * Primary Key - Unique ID for a particular row in the person_stocksymbol table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person_stocksymbol table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return get the Person interested in this stock
     */

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    /**
     * Specify the Person interested in the stock
     *
     * @param person a person instance
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     *
     * @return get the stock the person is interested in
     */

    @ManyToOne
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 4)
    public String getSymbol() {
        return symbol;
    }


    /**
     * Specify the stock the person is interested in
     *
     * @param symbol a stock symbol
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonStockSymbol that = (PersonStockSymbol) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + person.hashCode();
        result = 31 * result + symbol.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PersonStockSymbol{" +
                "id=" + id +
                ", person=" + person +
                ", symbol=" +  symbol +
                '}';
    }
}
