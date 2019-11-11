package com.origami.teach.apps;


import com.origami.teach.model.StockQuote;
import com.origami.teach.services.ServiceFactory;
import com.origami.teach.services.StockService;
import com.origami.teach.services.StockServiceException;
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

        StockQuote quote = stockService.getQuote("AMZN");
        System.out.println( quote.toString() );

        Date from = dateFormat.parse("2018-01-01");
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( from );

        Date until = dateFormat.parse("2019-01-01");
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( until );

        List<StockQuote> quotes = stockService.getQuote("AMZN", calendarFrom, calendarUntil );
        for(StockQuote quote1 : quotes) {
            System.out.println( quote1.toString() );
        }

    }
}

