<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Index Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>


        <!--        <div class="container">
                    <h1>Spring MVC Application from Archetype</h1>
                    <hr/>
                    <div class="navbar">
                        <ul class="nav nav-tabs">
                            <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                            <li role="presentation"><a href="${pageContext.request.contextPath}/hello/sayhi">Hello Controller</a></li>
                        </ul>    
                    </div>
                    <h2>Home Page</h2>
                </div>-->

        <div class="container-fluid">
            <div>
                <h1 class = "text-center">Vending Machine</h1>
            </div>
            <hr/>
            <div class="row">

                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                            </p>
                        </div>
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                        </div>
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                        </div>
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                        </div>
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                        </div>
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                        </div>
                        <div class="col-md-4">
                            <p>
                                1
                            </p>
                            <p>
                                Snickers
                            </p>
                            <p>
                                $1.85
                            </p>
                            <p>
                                Quantity Left: 9
                        </div>
                    </div>

                </div>
                <div class="col-md-4">
                    <h5 class="text-center">
                        Total $ In
                    </h5>
                    <p class="text-center">
                        ####
                    </p>
                    <div class="row">
                        <div class="col-md-6">

                            <button type="button" class="btn btn-primary btn-block">
                                Add Dollar
                            </button> 
                            <button type="button" class="btn btn-primary btn-block">
                                Add Quarter
                            </button>
                        </div>
                        <div class="col-md-6">

                            <button type="button" class="btn btn-primary btn-block">
                                Add Dime
                            </button> 
                            <button type="button" class="btn btn-primary btn-block">
                                Add Nickel
                            </button>
                        </div>
                    </div>

                    <hr/>

                    <h5 class="text-center">
                        Messages
                    </h5>
                    <p class="text-center">
                        #####
                    </p>
                    <div class="row">
                        <div class="col-md-6">
                            <p class = "text-center">
                                Item:
                            </p>
                        </div>
                        <div class="col-md-6">
                            <p class = "text-center">
                                ####
                            </p>
                        </div>
                    </div> 
                    <button type="button" class="btn btn-success btn-block">
                        Make Purchase
                    </button>
                    <hr/>
                    <h5 class="text-center">
                        Change
                    </h5>
                    <p class="text-center">
                        ####
                    </p> 
                    <button type="button" class="btn btn-success btn-block">
                        Change Return
                    </button>
                </div>
            </div>
        </div>



        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>