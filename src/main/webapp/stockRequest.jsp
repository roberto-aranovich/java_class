<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:useBean id="stockRequest" class="com.origami.teach.model.StockRequest" scope="request"/>
<jsp:setProperty name="stockRequest" property="*"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stock Quote Information Request</title>

</head>
<body>

<h2>
    Stock Quote Information Request<br>
</h2>

<P></P>

<form name="myform" action="servlets/ServletStockSearch/" method="post">
    Stock symbol : <input type="text" name="symbol"
                        value='<%= stockRequest.getSymbol() == null ? "" : stockRequest.getSymbol() %>'> <br>

    Get quotes from : <input type="text" name="from"
                       value='<%= stockRequest.getFrom()== null ? "" : stockRequest.getFrom() %>'> <br>

    Get quotes until : <input type="text" name="until"
                           value='<%= stockRequest.getUntil()== null ? "" : stockRequest.getUntil() %>'> <br>

    <br>
    Do you want to get the information from our database or from the web? <br>

    <br>
    Database:  <input type="checkbox" name="database" title="database"> <br>

    Web:       <input type="checkbox" name="web" title="web" > <br>
    <br>

    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>

</body>
</html>