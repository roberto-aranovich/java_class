package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.model.StockTable;
import com.origamisoftware.teach.advanced.util.DatabaseConnectionException;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class DatabaseStockService implements StockService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        // todo - this is a pretty lame implementation why?
        List<StockQuote> stockQuotes = null;
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            String queryString = "select * from quotes where symbol = '" + symbol + "'";

            ResultSet resultSet = statement.executeQuery( queryString );
            stockQuotes = new ArrayList<>( resultSet.getFetchSize() );
            while (resultSet.next()) {
                String symbolValue = resultSet.getString( "symbol" );
                Date time = resultSet.getDate( "time" );
                BigDecimal price = resultSet.getBigDecimal( "price" );
                stockQuotes.add( new StockQuote( price, time, symbolValue ) );
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException( exception.getMessage(), exception );
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException( "There is no stock data for:" + symbol );
        }

        return stockQuotes.get( 0 );
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException {
        // todo - this is a pretty lame implementation why?
        //  java.util.Date a = new java.util.Date(froma.getTime());
        //java.sql.Date from = new java.sql.Date(froma.getTime());

        List<StockQuote> stockQuotes = null;
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            String queryString = "select * from quotes where symbol = '" + symbol + "'";

            ResultSet resultSet = statement.executeQuery( queryString );
            stockQuotes = new ArrayList<>( resultSet.getFetchSize() );
            while (resultSet.next()) {

                String symbolValue = resultSet.getString( "symbol" );
                Date time = resultSet.getDate( "time" );
                BigDecimal price = resultSet.getBigDecimal( "price" );
                if (time.after( from.getTime() ) && time.before( until.getTime() )) {
                    stockQuotes.add( new StockQuote( price, time, symbolValue ) );
                }
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException( exception.getMessage(), exception );
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException( "There is no stock data for:" + symbol );
        }
        return stockQuotes;
    }

    /**
     * Add a new stock quote or update an existing one
     *
     * @param quote a stock quote to either update or create
     */
    @Override
    public void addOrUpdateQuote(StockTable quote) {
        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(quote);
            transaction.commit();
        } catch (HibernateException e) {
            System.out.println( e );
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction

            }
        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }
    }
}
