<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.User" %>
        <%
                    	User u = (User)session.getAttribute("utilisateur");
                    
                    
                    
                    %>
            <div class="mycontainer">
                <div style="padding-top = 50px">
                    <div class="profile">
                    
	                    <div class="list-group" style="width:570%;margin-top:50px">
						  <a class="list-group-item active"> My informations</a>
						  <a class="list-group-item"><% out.print("First Name :  " + u.getFirstName()); %></a>
						  <a class="list-group-item"><% out.print("Last Name :  " + u.getLastName()); %></a>
						  <a class="list-group-item"> <% out.print("Email :  " + u.getEmail()); %></a>
						</div>                    
                      
                    </div>
                </div>
            </div>