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
	   public ResultSet getEachFaculty(int loginid)  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from faculty where L_ID="+loginid); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   
	   public ResultSet getEachStudent(int login_id)  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from student where L_ID="+login_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   
	   public ResultSet getEachStudentPublication(int student_id)  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from paper where P_ID IN (Select P_ID from student_paper where S_ID=" +student_id+ ") "); 
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
	   public void addPublication(String student_publication_title,String student_publication_start,String student_publication_link,
			   String student_journal_name,String student_conference_name,String student_publication_end,String student_publication_submitdate,
			   String student_publication_isimp,String student_publication_issurv,String student_publication_isconf,String student_publication_isjor){   
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   String sql="Insert into paper(TITLE,STARTDATE,ENDDATE,SCOPUS_INDEXED,IS_JO,IS_CON,JNAME,CNAME,IS_SUR,IS_IMP,PSTATUS,IS_ELIGIBLE_DIST,IS_ELIGIBLE_GRACE,LINK,SUBMITDATE"
			   		+ ") VALUES ('"+student_publication_title+ "',"+ "'"+student_publication_start+"',"   
			   		+ "'"+student_publication_end+"'," 
			   		+ "'"+"Yes"+"'," 
			   		+ "'"+student_publication_isjor+"',"    
			   		+ "'"+student_publication_isconf+"',"   
			   		+ "'"+student_journal_name+"',"   
			   		+ "'"+student_conference_name+"',"   
			   		+ "'"+student_publication_issurv+"',"   
			   		+ "'"+student_publication_isimp+"',"   
			   		+ "'"+"Pending"+"',"   
			   		+ "'"+"Yes"+"',"   
			   		+ "'"+"No"+"',"
			   		+0+","
			   		+ "'"+student_publication_submitdate+"'"
			   		+");";
			   System.out.println(sql);
			   stmt.executeUpdate(sql); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		 
	   }
	   public ResultSet getAdminFaculty()  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from login where ISFACULTY='Yes'"); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   public ResultSet getAdminStudent()  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from login where ISFACULTY='No'"); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   


}
