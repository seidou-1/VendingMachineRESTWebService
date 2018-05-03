<%-- 
    Document   : index
    Created on : Apr 4, 2018, 2:08:23 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>`
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
        
        <p>How much do you want to bet?</p>
        
        <form method = "post" action = "LuckySevensServlet">
            <input type = "text" name = "userCash"/><br/> 
            <input type = "submit" value = "Let's Bet">
        </form>
        
    </body>
</html>
