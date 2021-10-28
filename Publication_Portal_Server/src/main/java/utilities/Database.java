package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database  {
	   public  ResultSet getFaculty() {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from faculty");  
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	}  
		   return rs2; 
		  
	   }
	   public  ResultSet getStudent()  {
		   ResultSet rs2=null;
		   int no_of_rows=0;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from student"); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
	   }
	   public ResultSet getEachFaculty()  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from faculty where F_ID=1"); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   
	   public ResultSet getEachStudent()  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from student where S_ID=1"); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   
	   public void addFaculty(String name,String email,String pass)  {
		   
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   String sql="Insert into faculty(Name,PhoneNO,DEPARTMENT,EMAIL,L_ID) VALUES ('"+name+ "',"+ "'None'" +","+ "'None'" + ",'"+email+"',"+"null"+");";
			   System.out.println(sql);
			   stmt.executeUpdate(sql); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		 
	   }

}
