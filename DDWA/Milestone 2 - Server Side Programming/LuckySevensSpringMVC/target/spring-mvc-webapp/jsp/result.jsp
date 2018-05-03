<%-- 
    Document   : result
    Created on : Apr 4, 2018, 4:48:02 PM
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
        
        
        <h1>Result</h1>
         
        <p>
            You betted ${userInput}
        </p>

        <p>
            You are broke after ${rollCount} rolls
        </p>

        <p>
            You should have quit after ${winningRolls} rolls when you had $${maxCash}
        </p>

        <p>
            <a href="index.jsp">Bet Again!</a>

        </p>
        
        
    </body>
</html>
