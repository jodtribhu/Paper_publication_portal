package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


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
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			   LocalDateTime now = LocalDateTime.now(); 
			   String ldate=dtf.format(now);
			   String sql="Insert into login(USERNAME,PASS,SALT,HASHVAL,CREATEDAT,MODIFIEDAT,ISFACULTY) VALUES ('"+name+ "','"+ pass+"',"+ "'sample_salt'" + ","+"'sample_hash','"+ldate+"','"+ldate+"',"+"'Yes"+"');";
			   stmt.executeUpdate(sql); 
			   
			   String sql4="Select * from login where USERNAME='"+name+"'";
			   System.out.println(sql4);
			   ResultSet rs=stmt.executeQuery(sql4);
			   int login_id=-1;
			   while(rs.next()) {
				    login_id=rs.getInt(1);
			   }
			   
			   String sql3="Insert into faculty(Name,PhoneNO,IDNO,DEPARTMENT,EMAIL,L_ID,CREATEDAT,DESIGNATION,CAMPUS) VALUES ('"+"Enter Name"+ "','"+ "Enter Phone "+"','"+name+ "',"+"'Enter department','"+email+"','"+login_id+"','"+ldate+"','"+"Enter Designation','"+"Enter Campus"+"');";
			   stmt.executeUpdate(sql3); 
			   System.out.println(sql3);
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		 
	   }
	   
	   
	   public void addStudent(String stuname,String stueroll,String stupassword)  {
		   
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			   LocalDateTime now = LocalDateTime.now(); 
			   String ldate=dtf.format(now);
			   String sql="Insert into login(USERNAME,PASS,SALT,HASHVAL,CREATEDAT,MODIFIEDAT,ISFACULTY) VALUES ('"+stuname+ "','"+ stupassword+"',"+ "'sample_salt'" + ","+"'sample_hash','"+ldate+"','"+ldate+"',"+"'No"+"');";
			   stmt.executeUpdate(sql); 
			   
			   String sql4="Select * from login where USERNAME='"+stuname+"'";
			   System.out.println(sql4);
			   ResultSet rs=stmt.executeQuery(sql4);
			   int login_id=-1;
			   while(rs.next()) {
				    login_id=rs.getInt(1);
			   }
			   
			   String sql3="Insert into student(Name,RollNO,EMAIL,PRE_RECORD,GRACEMARKS,L_ID,CAMPUS,SEX,PHONENO,DEPARTMENT) VALUES ('"+stuname+ "','"+ stueroll+"','"+"Enter Email"+ "',"+0+",'"+"0"+"',"+login_id+",'Enter Campus"+"','"+"Enter Sex"+"','"+"Enter Phone No','"+"Enter department"+"');";
			   System.out.println(sql3);
			   stmt.executeUpdate(sql3); 
			   
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
	   public void deleteAdminFaculty(int fid,int lid)  {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   
			   stmt.executeUpdate("DELETE FROM login WHERE L_ID="+lid); 
			   stmt.executeUpdate("DELETE FROM faculty WHERE F_ID="+fid); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		  
		 
	   }
	   


}
