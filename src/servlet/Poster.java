package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Poster
 */
@WebServlet("/Poster")
public class Poster extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/SOCIALNET";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Poster() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String post = request.getParameter("poste");
		String idS = request.getParameter("id");
		
		int id = Integer.parseInt(idS); 
		


		Statement stmt = null;
		
	   try{


	      Class.forName(JDBC_DRIVER);

	      java.sql.Connection con = DriverManager.getConnection(DB_URL, "root","");
	     
	      PreparedStatement ps = con.prepareStatement("INSERT INTO post (post,idUser) VALUES (?,?)");
	      
	    
	      ps.setString(1, post);
	      ps.setInt(2, id);

	      
	      int i = ps.executeUpdate();
	      
	      
	   }catch(Exception e2){System.out.println(e2); }
	  


	}

}
