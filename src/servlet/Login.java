package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

import bean.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/SOCIALNET";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	
		
		if (request.getParameter("submits") != "") {
		
		JSONArray jsonArray = new JSONArray();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		

		
		   try{


		      Class.forName(JDBC_DRIVER);

		      java.sql.Connection con = DriverManager.getConnection(DB_URL, "root","");
		     
		      
		    
		       // Créer un objet MetaData de ResultSet
		      java.sql.PreparedStatement result = con.prepareStatement("select * from user where email = ? and password = ? ");
		      
		      result.setString(1, email);
		      result.setString(2, password);
		      
		       ResultSet res = result.executeQuery();
		       ResultSetMetaData rsMetaData=(ResultSetMetaData) res.getMetaData();
		       // Accéder à la liste des colonnes
		       
		       int nbrColonne = rsMetaData.getColumnCount();
		       
		    

		       User user = new User();
		       
		    	  
		       int taille = 0;
		       
		       while (res.next()) {
	                JSONObject json = new JSONObject();
	            
	                user.setId(res.getString("id"));
	                user.setFirstName(res.getString("firstname"));
	                user.setLastName(res.getString("lastname"));
	                user.setEmail(res.getString("email"));
	                user.setPassword(res.getString("password"));
	                
	                
	                taille ++;
	                
	            }

		       
		       HttpSession session = request.getSession();
		       session.setAttribute("utilisateur", user);

		       if (taille != 0){
					this.getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
		    	   
					 
				}else{
					response.setContentType("text/html");
					 PrintWriter out = response.getWriter();
					 out.println("User not found");
				}
		    

		   }catch(Exception e2){System.out.println(e2); }
		  
			
			
		}
	}

}
	

		
	


