package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.model.StockTable;
import com.origamisoftware.teach.advanced.util.DatabaseUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
public class HttpStockService implements StockService {

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
    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException, ParseException, java.text.ParseException {
        ArrayList<StockQuote> stockQuotes = new ArrayList<>();
        try {
            String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&outputsize=full&apikey=GTOFCCAE7URQCGCT";
            URL url = new URL( urlString );
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader( url.openStream() ) );
            String inputLine;
            String jsonString = "";
            while ((inputLine = bufferedReader.readLine()) != null) {
                jsonString = jsonString + inputLine;
            }
            bufferedReader.close();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse( jsonString );
            JSONObject metaData = (JSONObject) jsonObject.get( "Meta Data" );
            JSONObject timeSeries = (JSONObject) jsonObject.get( "Time Series (Daily)" );
            Collection a = timeSeries.keySet();

            for(Object key : a){
                JSONObject entry  = (JSONObject) timeSeries.get(key);
                String closeString = ((String) entry.get( "4. close" ));
                Float closeFloat = Float.parseFloat(closeString);
                BigDecimal price = new BigDecimal( closeFloat );
                java.util.Date date = dateFormat.parse( (String) key );
                StockQuote quote = new StockQuote(price, date, symbol);
                stockQuotes.add( quote );
            }

        } catch (MalformedURLException exception) {
            throw new StockServiceException( exception.getMessage(), exception );
        } catch (IOException exception) {
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
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException, java.text.ParseException, ParseException {

        ArrayList<StockQuote> stockQuotes = new ArrayList<>();
        try {
            String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&outputsize=full&apikey=GTOFCCAE7URQCGCT";
            URL url = new URL( urlString );
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader( url.openStream() ) );
            String inputLine;
            String jsonString = "";
            while ((inputLine = bufferedReader.readLine()) != null) {
                jsonString = jsonString + inputLine;
            }
            bufferedReader.close();
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse( jsonString );
            JSONObject metaData = (JSONObject) jsonObject.get( "Meta Data" );
            JSONObject timeSeries = (JSONObject) jsonObject.get( "Time Series (Daily)" );
            Collection a = timeSeries.keySet();

            for(Object key : a){
                JSONObject entry  = (JSONObject) timeSeries.get(key);
                String closeString = ((String) entry.get( "4. close" ));
                Float closeFloat = Float.parseFloat(closeString);
                BigDecimal price = new BigDecimal( closeFloat );
                java.util.Date date = dateFormat.parse( (String) key );
                StockQuote quote = new StockQuote(price, date, symbol);
                if (date.after( from.getTime() ) && date.before( until.getTime() )) {
                    stockQuotes.add( quote );
                }
            }

        } catch (MalformedURLException exception) {
            throw new StockServiceException( exception.getMessage(), exception );
        } catch (IOException exception) {
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
