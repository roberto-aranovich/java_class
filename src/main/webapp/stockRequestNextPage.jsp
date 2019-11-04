<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.origami.teach.model.StockQuote"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stock Information</title>
</head>
<body>

<% List<StockQuote> quotes = (List<StockQuote>)request.getAttribute("quotes");

    for(StockQuote quote : quotes)
    {
        out.print(quote.toString());
    }

%>

</body>
</html>
