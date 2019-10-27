package com.origamisoftware.teach.advanced.apps.stockquote;


import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.services.ServiceFactory;
import com.origamisoftware.teach.advanced.services.StockService;
import com.origamisoftware.teach.advanced.services.StockServiceException;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HttpStockServiceExample {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException, StockServiceException {
       StockService stockService = ServiceFactory.getHttpServiceInstance();

        StockQuote quote = stockService.getQuote("MMM");
        System.out.println( quote.toString() );

        Date from = dateFormat.parse("2018-01-01");
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );

        Date until = dateFormat.parse("2019-01-01");
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( until );

        List<StockQuote> quotes = stockService.getQuote("MMM", calendarFrom, calendarUntil );
        for(StockQuote quote1 : quotes) {
            System.out.println( quote1.toString() );
        }

    }
}

