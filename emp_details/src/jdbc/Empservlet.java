package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/Empservlet")
public class Empservlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	
	
	{

		
		String efname = req.getParameter("fname");
		String emname = req.getParameter("mname");
		String elname = req.getParameter("lname");
		String eid = req.getParameter("eid");
		int epass=Integer.parseInt(req.getParameter("pass"));
		String eplc = req.getParameter("plc");
		
	
		
		String sql="insert into empdetails(efname,emname,elname,eeid,epnum,eplc)values(?,?,?,?,?,?)";
		
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root","1068");
				PreparedStatement ps=(PreparedStatement) con.prepareStatement(sql);
			//s.setInt(1,id);
				ps.setString(1,efname);
				ps.setString(2,emname);
				
				ps.setString(3,elname);
				ps.setString(4, eid);
				ps.setInt(5,epass);
ps.setString(6, eplc);
				
			
				
			ps.executeUpdate();
			PrintWriter out=res.getWriter();
			out.println("you are successully rgistrared");
				
			} catch (Exception e) 
			{
				
				e.printStackTrace();
			}
			
		
		
		
		
		
	}

}
