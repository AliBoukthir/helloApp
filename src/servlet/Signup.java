package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.*;

import bean.User;
/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/SOCIALNET";
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

		Statement stmt = null;
			
		   try{


		      Class.forName(JDBC_DRIVER);

		      java.sql.Connection con = DriverManager.getConnection(DB_URL, "root","");
		     
		      PreparedStatement ps = con.prepareStatement("INSERT INTO user (firstName,lastName,email,password) VALUES (?,?,?,?)");
		      
		    
		      ps.setString(1, firstName);
		      ps.setString(2, lastName);
		      ps.setString(3, email);
		      ps.setString(4, password);

		      int i = ps.executeUpdate();
		      
		   }catch(Exception e2){System.out.println(e2); }
		  
		this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
		
		
	}

}
