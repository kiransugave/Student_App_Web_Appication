package studentcrudOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updatelink")
public class updateStudent extends HttpServlet{
	Connection con;
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja7", "root","sql123");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // fetch the data from HTML
    	   int id=Integer.parseInt(req.getParameter("studentid"));
    	   String name=req.getParameter("studentname");
    	   String stream=req.getParameter("stream");
    	   // set values
    	   PreparedStatement pstmt=null;
    	   
    	   String query="update student_info  ";
    	   
    	   try {
			pstmt=con.prepareStatement(query);
			   pstmt.setInt(1, id);
	    	   pstmt.setString(2, name);
	    	   pstmt.setString(3, stream);
	    	   int count=pstmt.executeUpdate();
	    	   PrintWriter pw=resp.getWriter();
	    	   pw.print("<h1>"+count+"RECORD UPDATE");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
    	   
       }
    
}
