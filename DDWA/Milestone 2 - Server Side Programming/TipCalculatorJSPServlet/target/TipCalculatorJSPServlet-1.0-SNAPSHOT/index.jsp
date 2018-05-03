<%-- 
    Document   : index
    Created on : Apr 2, 2018, 7:11:05 PM
    Author     : laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tip Calculator</title>
    </head>
    <body>
       <h1>Tip Calculator!</h1>
        <form action="TipCalculatorServlet" method="POST">
            <div>
                <label for="billAmt">Bill Amount</label>
                <input type="text" name="billAmt" id="billAmt"/>
            </div>
            <div>
                <label for="tip">Tip %</label>
                <input type="text" name="tip" id="tip"/>
            </div>
            <div>
                <input type="submit" value="Calculate Tip" />
            </div>
        </form>
    </body>
</html>
