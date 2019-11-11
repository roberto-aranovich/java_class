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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Simple Example of how a servlet can access form submission data
 * and act on it accordingly.
 */
public class ServletStockSearch extends HttpServlet {

    static SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
    private static final String DATABASE_PARAMETER_KEY = "database";
    private static final String WEB_PARAMETER_KEY = "web";
    private static final String CHECK_BOX_IS_CHECKED_VALUE = "on";

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param request  an instance of HttpServletRequest
     * @param response an instance of HttpServletResponse
     * @throws ServletException, IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String database = request.getParameter( DATABASE_PARAMETER_KEY );
        String web = request.getParameter( WEB_PARAMETER_KEY );

        String message = "";

        if ((database != null && database.equals( CHECK_BOX_IS_CHECKED_VALUE )) && (web != null && web.equals( CHECK_BOX_IS_CHECKED_VALUE ))) {
            message = message + "You have checked both database and web. Please, select only one option. Thanks :)";
            session.setAttribute( "message", message );
        } else {
            if ((database == null) && (web == null)) {
                message = message + "You haven't checked any box. Please, select either database or web. Thanks :)";
                session.setAttribute( "message", message );
            }
        }

        if (message != "") {
            ServletContext servletContext = getServletContext();
            RequestDispatcher dispatcher =
                    servletContext.getRequestDispatcher( "/stockRequestMessage.jsp" );
            dispatcher.forward( request, response );
        } else {
            boolean useDatabase = false;
            if (database != null && database.equals( CHECK_BOX_IS_CHECKED_VALUE )) {
                useDatabase = true;
            }

            Boolean useWeb = false;
            if (web != null && web.equals( CHECK_BOX_IS_CHECKED_VALUE )) {
                useWeb = true;
            }

            String symbol = request.getParameter( "symbol" );
            String from = request.getParameter( "from" );
            String until = request.getParameter( "until" );

            StockService stockService = null;
            if (useDatabase) {
                try {
                    stockService = ServiceFactory.getDatabaseStockService();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                if (useWeb) {
                    stockService = ServiceFactory.getHttpServiceInstance();
                }
            }

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

            List<StockQuote> quotes = null;
            try {
                quotes = stockService.getQuote( symbol, calendarFrom, calendarUntil );
            } catch (StockServiceException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (org.json.simple.parser.ParseException e) {
                e.printStackTrace();
            }

            // Sending the list of stock quotes produces a NullPointerException
            // session.setAttribute("quotes", quotes);

            //sending the first element of the list instead
            session.setAttribute( "quote", quotes.get( 0 ) );

            ServletContext servletContext = getServletContext();
            RequestDispatcher dispatcher =
                    servletContext.getRequestDispatcher( "/stockRequestNextPage.jsp" );
            dispatcher.forward( request, response );
        }
    }
}