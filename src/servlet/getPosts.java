package servlet;

import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class getPosts
 */
@WebServlet("/getPosts")
public class getPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/SOCIALNET";
	   
	   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPosts() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		JSONArray jsonArray = new JSONArray();

				
				
			   try{


			      Class.forName(JDBC_DRIVER);

			      java.sql.Connection con = DriverManager.getConnection(DB_URL, "root","");
			     
			      
			      java.sql.Statement stmt=con.createStatement();
			       // Créer un objet MetaData de ResultSet
			       ResultSet res=stmt.executeQuery("select * from user inner join  post on user.id = post.idUser ");
			       ResultSetMetaData rsMetaData=(ResultSetMetaData) res.getMetaData();
			       // Accéder à la liste des colonnes
			       
			       int nbrColonne = rsMetaData.getColumnCount();
			       while (res.next()) {
		                JSONObject json = new JSONObject();
		 
		                for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
		                    Object obj = res.getObject(i);
		                    if (obj == null) {
		 
		                        json.put(rsMetaData.getColumnName(i), "null");
		                    } else {
		 
		                        json.put(rsMetaData.getColumnName(i), obj.toString());
		                    }
		 
		                }
		 
		                jsonArray.put(json);
		            }
			      

			   }catch(Exception e2){System.out.println(e2); }

			   	response.setContentType("application/json");
				  
				PrintWriter out = response.getWriter();
				
				out.print(jsonArray);
				out.flush();
			   



	}

}
