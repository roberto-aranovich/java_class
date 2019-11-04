package com.origami.teach.servlet;

import com.origami.teach.model.StockQuote;
import com.origami.teach.services.ServiceFactory;
import com.origami.teach.services.StockService;
import com.origami.teach.services.StockServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Simple Example of how a servlet can access form submission data
 * and act on it accordingly.
 */
public class ServletStockSearch extends HttpServlet {

    static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {


        String symbol = request.getParameter("symbol");
        String from = request.getParameter("from");
        String until = request.getParameter( "until" );

        HttpSession session = request.getSession();
        StockService stockService = ServiceFactory.getHttpServiceInstance();

        Date dateFrom = null;
        try {
            dateFrom = dateFormat.parse( from );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendarFrom = Calendar.getInstance();
        calendarFrom.setTime( dateFrom );

        Date dateUntil = null;
        try {
            dateUntil = dateFormat.parse( until );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendarUntil = Calendar.getInstance();
        calendarUntil.setTime( dateUntil );


        List<StockQuote> quotes = new ArrayList<StockQuote>();
        try {
            quotes = stockService.getQuote(symbol, calendarFrom, calendarUntil );
        } catch (StockServiceException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }

        session.setAttribute("quotes", quotes);

        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("/stockRequestNextPage.jsp");
        dispatcher.forward(request, response);

    }
}
