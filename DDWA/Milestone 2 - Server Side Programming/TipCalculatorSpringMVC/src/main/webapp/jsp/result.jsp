<%-- 
    Document   : result
    Created on : Apr 4, 2018, 5:27:40 PM
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
        <h1>Tip Result!</h1>
        <p>Amount: $ ${startingBill}</p>
        <p>Tip %: ${tipAmount}</p>
        <p>Tip Amount: $ ${totalTip}</p>
        <p>Total Bill: $ ${totalBill}</p>

        <p>
            <a href="index.jsp">Calculate Again!</a>
        </p>
        
    </body>
</html>
