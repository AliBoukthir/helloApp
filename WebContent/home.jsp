<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.User" %>
        <%@ page session="true" %>
            <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <html ng-app="routeApp">

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
                <title>Insert title here</title>
                <link rel="stylesheet" href="inc/css/bootstrap.min.css">
                <link rel="stylesheet" href="inc/css/home.css"> </head>

            <body ng-app>
                <div id="wrapper">
                    <nav class="navbar navbar-default">
                        <%
                    	//User u = (User)session.getAttribute("utilisateur");
              			String u = request.getParameter("utilisateur");
                    
                    
                    %>
                            <% System.out.print("uu= dd"+ u); %>
                                <div class="container-fluid">
                                    <!-- Brand and toggle get grouped for better mobile display -->
                                    <div class="navbar-header">
                                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button> <a class="navbar-brand" href="#">Home</a> </div>
                                    <!-- Collect the nav links, forms, and other content for toggling -->
                                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                                        <form class="navbar-form navbar-left" style="margin-left : 840px">
                                            <div class="form-group">
                                                <input type="text" class="form-control" placeholder="Search"> </tewtarea>
                                            </div>
                                            <button type="submit" class="btn btn-default">Search</button>
                                        </form>
                                        <ul class="nav navbar-nav navbar-right">
                                            <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Settings <span class="caret"></span></a>
                                                <ul class="dropdown-menu">
                                                    <li><a href="#/profile">Profile</a></li>
                                                    <li role="separator" class="divider"></li>
                                                    <li><a href="./login.jsp">Sign Out</a></li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                    <!-- /.navbar-collapse -->
                                </div>
                                <!-- /.container-fluid -->
                    </nav>
                    <div ng-view> </div>
                    <div id="footer"> </div>
                </div>
                <script src="inc/js/jquery-1.12.1.min.js"></script>
                <script src="inc/js/bootstrap.min.js"></script>
                <script src="inc/js/angular.min.js"></script>
                <script src="inc/js/angular-route.min.js"></script>
                <script src="inc/js/front.js"></script>
                <script src="inc/js/app.js"></script>
            </body>

            </html>