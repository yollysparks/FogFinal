<%-- 
    Document   : CarportPartsGenerator
    Created on : Apr 22, 2017, 3:52:28 PM
    Author     : Jack
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSSz.css">
        <title>Carport Generator 0.1</title>
    </head>
    <body>
        <h1>Carport Generator 0.1</h1>
        <form action="CarportInput" method="POST">
            <br>
            Wight:
            <input type="text" name="wight">
            <br>
            <br>
            Length:
            <input type="text" name="length">
            <br>
            <input type="radio" name="roofTopType" value="flat" checked> A flat rooftop<br>
            <br>
            <input type="radio" name="roofTopType" value="big"> A bigass rooftop<br>
            <input type="submit" value="Generate">
        </form>
    <br>
<TR>
<TD><FORM ACTION="connectJspToMysql.jsp" method="get" >
<button type="submit">BACK</button></TD>
</TR>
    </body>
</html>
