<%-- 
    Document   : index
    Created on : Apr 2, 2018, 6:30:56 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Factorizor</h1>
        
        <p>
            Please enter the number you want to factor:
        </p>
        <form method="post" action="FactorizorServlet">
            <input type="text" name="numberToFactor"/><br/>
            <input type="submit" value="Find Factors!!!"/>
        </form>
    </body>
</html>
