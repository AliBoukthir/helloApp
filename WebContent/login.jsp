<%@page import="java.util.*"%>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
            <meta charset="UTF-8">
            <title>Se connecter - Flowers - Meet friends</title>
            <link rel="stylesheet" href="inc/css/bootstrap.min.css">
            <link rel="stylesheet" href="inc/css/login.css">
            <link rel="icon" type="image/png" href="icons/icon.png" sizes="128x128"> </head>

        <body style='background-image: url("inc/img/bg.jpg");background-position:center;background-size: cover'>
            <div id="wrapper">
                <div id="content">
                    <div class="box">
                        <div class="bar">
                            <div class="log selected" data-class="login">Login</div>
                            <div class="sign" data-class="signup">Signup</div>
                        </div>
                        <center><img src="inc/img/logo-text.svg" alt="logo" style="width:37%"></center>
                        <div class="log-form">
                            <!-- start login form -->
                            <form class="login" method="post" action="home">
                                <div class="form-group">
                                    <input name="email" type="email" class="form-control" placeholder="Email" required> </div>
                                <div class="form-group">
                                    <input name="password" type="password" class="form-control" placeholder="Password" required> </div>
                                <button name="submit" style="width:100%;background-color:#00b5b5;border:none;" type="submit" class="btn btn-primary">Log-in</button>
                            </form>
                            <!-- end login-form-->
                            <!-- start signup form -->
                            <form class="signup" method="post" action="signup">
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="First Name" name="firstName" required> </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" placeholder="Last Name" name="lastName" required> </div>
                                <div class="form-group">
                                    <input type="email" class="form-control" placeholder="Email" name="email" required> </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" placeholder="Password" name="password" required> </div>
                                <button style="width:100%;background-color:#00b5b5;border:none;" type="submit" class="btn btn-primary">Sign-up</button>
                            </form>
                            <!-- end signup-form-->
                            <% if (request.getParameter("firstName") != null)
                    {
                    	%> Hello <b><%= request.getParameter("firstName") %></b> Login please
                                <%
                    }
                    	%>
                                    </b>
                        </div>
                    </div>
                </div>
                <div id="footer">
                    <center>All rights reserved HellO 2016</center>
                </div>
                <script src="inc/js/jquery-1.12.1.min.js"></script>
                <script src="inc/js/front.js"></script>
                <script src="inc/js/bootstrap.min.js"></script>
            </div>
        </body>

        </html>

        </html>