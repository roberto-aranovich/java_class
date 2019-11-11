<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.origami.teach.model.StockQuote"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Information</title>
</head>
<body>

 <%--
 Displaying a list produces a NullPointerException
 --%>

 <%--
 <% List<StockQuote> quotes = (List<StockQuote>)request.getAttribute("quotes");

     for(StockQuote quote : quotes)
     {
         out.print(quote.toString());
     }

 %>
 --%>

 <%--
  Displaying a single stock quote instead.
  --%>

<h3> Stock Information: </h3>
Symbol: ${quote.getSymbol()} <br/>
Price: ${quote.getPrice()} <br/>
Date: ${quote.getDate()}

</body>
</html>
