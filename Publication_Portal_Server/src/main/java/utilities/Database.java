package utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Database {
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
			   return stmt.executeQuery("Select * from paper,student_paper where paper.P_ID IN (Select P_ID from student_paper where S_ID=" +student_id+ ")  && paper.P_ID=student_paper.P_ID && student_paper.S_ID="+student_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   
	   
	   public ResultSet getEachFacultyPublication(int faculty_id)  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select * from paper,paper_faculty,student_paper,student where paper.P_ID IN (Select P_ID from paper_faculty where F_ID="+faculty_id+")  && paper.P_ID=paper_faculty.P_ID && paper_faculty.F_ID="+faculty_id+"  &&student_paper.SP_ID=paper_faculty.SP_ID && student.S_ID=student_paper.S_ID"); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   
	   public void addFaculty(String name,String email,String pass) throws NoSuchAlgorithmException  {
	        String passwordToHash = pass;
	        String salt = getSalt();
	        
	        String securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			   LocalDateTime now = LocalDateTime.now(); 
			   String ldate=dtf.format(now);
			   String sql="Insert into login(USERNAME,PASS,SALT,HASHVAL,CREATEDAT,MODIFIEDAT,ISFACULTY,ISADMIN) VALUES ('"+name+ "','"+ securePassword+"','"+ salt + "',"+"'SHA_512','"+ldate+"','"+ldate+"',"+"'Yes"+"','No');";
			   stmt.executeUpdate(sql); 
			   
			   String sql4="Select * from login where USERNAME='"+name+"'";
			   System.out.println(sql4);
			   ResultSet rs=stmt.executeQuery(sql4);
			   int login_id=-1;
			   while(rs.next()) {
				    login_id=rs.getInt(1);
			   }
			   
			   String sql3="Insert into faculty(Name,PhoneNO,IDNO,DEPARTMENT,EMAIL,L_ID,DESIGNATION,CAMPUS) VALUES ('"+"Enter Name"+ "','"+ "Enter Phone "+"','"+name+ "',"+"'Enter department','"+email+"','"+login_id+"','"+"Enter Designation','"+"Enter Campus"+"');";
			   stmt.executeUpdate(sql3); 
	
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		 
	   }
	   //Login Hashing and salt 
	    private static String get_SHA_512_SecurePassword(String passwordToHash,
	            String salt) {
	        String generatedPassword = null;
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-512");
	            md.update(salt.getBytes());
	            byte[] bytes = md.digest(passwordToHash.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (int i = 0; i < bytes.length; i++) {
	                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
	                        .substring(1));
	            }
	            generatedPassword = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        return generatedPassword;
	    }
	    
	    private static String getSalt() throws NoSuchAlgorithmException {
	        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
	        byte[] salt = new byte[16];
	        sr.nextBytes(salt);
	        return salt.toString();
	    }
	   
	   
	   public void addStudent(String stuname,String stueroll,String stupassword) throws NoSuchAlgorithmException  {
	        String passwordToHash = stupassword;
	        String salt = getSalt();
	        
	        String securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
	        
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
			   LocalDateTime now = LocalDateTime.now(); 
			   String ldate=dtf.format(now);
			   String sql="Insert into login(USERNAME,PASS,SALT,HASHVAL,CREATEDAT,MODIFIEDAT,ISFACULTY,ISADMIN) VALUES ('"+stueroll+ "','"+ securePassword+"','"+ salt + "',"+"'SHA_512','"+ldate+"','"+ldate+"',"+"'No"+"','No');";
			   stmt.executeUpdate(sql); 
			   
			   String sql4="Select * from login where USERNAME='"+stueroll+"'";
			  
			   ResultSet rs=stmt.executeQuery(sql4);
			   int login_id=-1;
			   while(rs.next()) {
				    login_id=rs.getInt(1);
			   }
			   
			   String sql3="Insert into student(Name,RollNO,EMAIL,PRE_RECORD,GRACEMARKS,L_ID,CAMPUS,SEX,PHONENO,DEPARTMENT) VALUES ('"+stuname+ "','"+ stueroll+"','"+"Enter Email"+ "',"+0+",'"+"0"+"',"+login_id+",'Enter Campus"+"','"+"Enter Sex"+"','"+"Enter Phone No','"+"Enter department"+"');";
			 
			   stmt.executeUpdate(sql3); 
			   
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		 
	   }
	   
	   public void addPublication(String student_publication_title,String student_publication_start,String student_publication_link,
			   String student_journal_name,String student_conference_name,String student_publication_end,String student_publication_submitdate,
			   String student_publication_isimp,String student_publication_issurv,String student_publication_isconf,String student_publication_isjor,String addp1,String addp2,String addp3,String addp4,String faculty_id_no){   
	
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   String sql="Insert into paper(TITLE,STARTDATE,ENDDATE,SCOPUS_INDEXED,IS_JO,IS_CON,JNAME,CNAME,IS_SUR,IS_IMP,IS_ELIGIBLE_DIST,IS_ELIGIBLE_GRACE,LINK,SUBMITDATE"
			   		+ ") VALUES ('"+student_publication_title+ "',"+ "'"+student_publication_start+"',"   
			   		+ "'"+student_publication_end+"'," 
			   		+ "'"+"Yes"+"'," 
			   		+ "'"+student_publication_isjor+"',"    
			   		+ "'"+student_publication_isconf+"',"   
			   		+ "'"+student_journal_name+"',"   
			   		+ "'"+student_conference_name+"',"   
			   		+ "'"+student_publication_issurv+"',"   
			   		+ "'"+student_publication_isimp+"',"   
			   		  
			   		+ "'"+"Yes"+"',"   
			   		+ "'"+"No"+"','"
			   		+student_publication_link+"',"
			   		+ "'"+student_publication_submitdate+"'"
			   		+");";
	
			   stmt.executeUpdate(sql);
			
			   
			   Statement stmt2=con.createStatement();
			   String sql2="Select P_ID from paper where TITLE='"+student_publication_title+"'";
	
			   ResultSet rs4 =stmt2.executeQuery(sql2);
			   int p_Id=-1;
			   while(rs4.next()) {
				    p_Id=rs4.getInt(1);
			   }
			   Statement stmt3=con.createStatement();
			   Statement stmt4=con.createStatement();
			   if(!addp1.isEmpty()) {
				   String sql3="Insert into student_paper(S_ID,P_ID,IS_CLAIMED,MARKS,PSTATUS) VALUES ("+addp1+","+p_Id+","+"'No',"+"0"+",'Pending')";
		
				   stmt.executeUpdate(sql3);
				   
				   //Faculty Paper
				   Statement stmt5=con.createStatement();
				   Statement stmt6=con.createStatement();
				   Statement stmt7=con.createStatement();
				   String sql5="Select F_ID from faculty where IDNO='"+faculty_id_no+"'";
				   ResultSet fs6=stmt5.executeQuery(sql5);
				   int f_id=-1;
				   while(fs6.next()) {
					   f_id=fs6.getInt(1);
				   }
				   String sql6="Select SP_ID from student_paper where S_ID="+addp1+" AND P_ID= "+p_Id;
				   ResultSet fs7=stmt6.executeQuery(sql6);
				   int sp_id=-1;
				   while(fs7.next()) {
					   sp_id=fs7.getInt(1);
				   }
				   String sql7="Insert into paper_faculty(P_ID,F_ID,SP_ID,REMARKS) VALUES ("+p_Id+","+f_id+","+sp_id+","+"'No Remarks'"+")";
				   stmt7.executeUpdate(sql7);
				   
			   }
			   if(!addp2.isEmpty()) {
				  
				   String sql4="Select S_ID from student where RollNO='"+addp2+"'";
				   ResultSet fs5=stmt4.executeQuery(sql4);
				   int s_id=-1;
				   while(fs5.next()) {
					   s_id=fs5.getInt(1);
				   }
				   
				   
				   String sql3="Insert into student_paper(S_ID,P_ID,IS_CLAIMED,MARKS,PSTATUS) VALUES ("+s_id+","+p_Id+","+"'No',"+"0"+",'Pending')";
			
				   stmt3.executeUpdate(sql3);
				   
				   
				   //Faculty Paper
				   Statement stmt5=con.createStatement();
				   Statement stmt6=con.createStatement();
				   Statement stmt7=con.createStatement();
				   String sql5="Select F_ID from faculty where IDNO='"+faculty_id_no+"'";
				   ResultSet fs6=stmt5.executeQuery(sql5);
				   int f_id=-1;
				   while(fs6.next()) {
					   f_id=fs6.getInt(1);
				   }
				   String sql6="Select SP_ID from student_paper where S_ID="+s_id+" AND P_ID= "+p_Id;
				   ResultSet fs7=stmt6.executeQuery(sql6);
				   int sp_id=-1;
				   while(fs7.next()) {
					   sp_id=fs7.getInt(1);
				   }
				   String sql7="Insert into paper_faculty(P_ID,F_ID,SP_ID,REMARKS) VALUES ("+p_Id+","+f_id+","+sp_id+","+"'No Remarks'"+")";
				   stmt7.executeUpdate(sql7);
			   }
			 
			   if(!addp3.isEmpty()) {
				   String sql4="Select S_ID from student where RollNO='"+addp3+"'";
				   ResultSet fs5=stmt4.executeQuery(sql4);
				   int s_id=-1;
				   while(fs5.next()) {
					   s_id=fs5.getInt(1);
				   }
				   String sql3="Insert into student_paper(S_ID,P_ID,IS_CLAIMED,MARKS,PSTATUS) VALUES ("+s_id+","+p_Id+","+"'No',"+"0"+",'Pending')";
			
				   stmt3.executeUpdate(sql3);
				   
				   //Faculty Paper
				   Statement stmt5=con.createStatement();
				   Statement stmt6=con.createStatement();
				   Statement stmt7=con.createStatement();
				   String sql5="Select F_ID from faculty where IDNO='"+faculty_id_no+"'";
				   ResultSet fs6=stmt5.executeQuery(sql5);
				   int f_id=-1;
				   while(fs6.next()) {
					   f_id=fs6.getInt(1);
				   }
				   String sql6="Select SP_ID from student_paper where S_ID="+s_id+" AND P_ID= "+p_Id;
				   ResultSet fs7=stmt6.executeQuery(sql6);
				   int sp_id=-1;
				   while(fs7.next()) {
					   sp_id=fs7.getInt(1);
				   }
				   String sql7="Insert into paper_faculty(P_ID,F_ID,SP_ID,REMARKS) VALUES ("+p_Id+","+f_id+","+sp_id+","+"'No Remarks'"+")";
				   stmt7.executeUpdate(sql7);
			   }
			
			   if(!addp4.isEmpty()) {
				   String sql4="Select S_ID from student where RollNO='"+addp4+"'";
				   ResultSet fs5=stmt4.executeQuery(sql4);
				   int s_id=-1;
				   while(fs5.next()) {
					   s_id=fs5.getInt(1);
				   }
				   String sql3="Insert into student_paper(S_ID,P_ID,IS_CLAIMED,MARKS,PSTATUS) VALUES ("+s_id+","+p_Id+","+"'No',"+"0"+",'Pending')";
			
				   stmt3.executeUpdate(sql3);
				   
				   //Faculty Paper
				   Statement stmt5=con.createStatement();
				   Statement stmt6=con.createStatement();
				   Statement stmt7=con.createStatement();
				   String sql5="Select F_ID from faculty where IDNO='"+faculty_id_no+"'";
				   ResultSet fs6=stmt5.executeQuery(sql5);
				   int f_id=-1;
				   while(fs6.next()) {
					   f_id=fs6.getInt(1);
				   }
				   String sql6="Select SP_ID from student_paper where S_ID="+s_id+" AND P_ID= "+p_Id;
				   ResultSet fs7=stmt6.executeQuery(sql6);
				   int sp_id=-1;
				   while(fs7.next()) {
					   sp_id=fs7.getInt(1);
				   }
				   String sql7="Insert into paper_faculty(P_ID,F_ID,SP_ID,REMARKS) VALUES ("+p_Id+","+f_id+","+sp_id+","+"'No Remarks'"+")";
				   stmt7.executeUpdate(sql7);
			   } 
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
			   return stmt.executeQuery("Select * from login where ISFACULTY='No' and ISADMIN='No'"); 
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
			   stmt.executeUpdate("DELETE FROM paper_faculty WHERE F_ID="+fid);
			   stmt.executeUpdate("DELETE FROM faculty WHERE F_ID="+fid); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
	   }
	   public void deleteAdminStudent(int sid,int lid)  {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   
			   Statement stmt2=con.createStatement();  
			   ResultSet fs10=stmt2.executeQuery("Select * from student_paper WHERE S_ID ="+sid); 
			   while(fs10.next()) {
				   
				   int sp_id=fs10.getInt(1);
				   stmt.executeUpdate("DELETE FROM paper_faculty WHERE SP_ID="+sp_id);
			   };
			   
			   
			   
			   stmt.executeUpdate("DELETE FROM login WHERE L_ID="+lid); 
			   
			   stmt.executeUpdate("DELETE FROM publication_portal.student_paper WHERE S_ID="+sid);
			   stmt.executeUpdate("DELETE FROM publication_portal.student WHERE S_ID="+sid); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
	   }
	   public void claimPublication(int sp_id)  {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   stmt.executeUpdate("Update student_paper SET IS_CLAIMED='Yes' where sp_id="+sp_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
	   }
	   public void unclaimPublication(int sp_id)  {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   stmt.executeUpdate("Update student_paper SET IS_CLAIMED='No' where sp_id="+sp_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
	   }
	   
	   public ResultSet getEachStudentPublicationTeamStatus(int p_id)  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			  return stmt.executeQuery("Select * from student_paper where P_ID="+p_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		  return rs2;
		 
	   }
	   

	   
	   public ResultSet getEachMateName(int s_id)  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   return stmt.executeQuery("Select name,S_ID from student where S_ID="+s_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2; 
		 
	   }
	   public void editStudent(int s_id,String editname,String editroll ,String editdept ,String editgender ,String editcampus ,String editmobile,String editemail)  {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   stmt.executeUpdate("Update student SET Name='"+editname+"',RollNO='" +editroll+"',EMAIL='"+editemail+"',CAMPUS='"+editcampus+"',SEX='"+editgender+"',PHONENO='"+editmobile+"',DEPARTMENT='"+editdept+"' where S_ID="+s_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		  
		 
	   }
	   public void editFaculty(int f_id,String editname,String editroll ,String editdept ,String editdesig ,String editcampus ,String editmobile,String editemail)  {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   stmt.executeUpdate("Update faculty SET Name='"+editname+"',IDNO='" +editroll+"',EMAIL='"+editemail+"',CAMPUS='"+editcampus+"',DESIGNATION='"+editdesig+"',PhoneNO='"+editmobile+"',DEPARTMENT='"+editdept+"' where F_ID="+f_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		  
		 
	   }
	public void acceptPublication(String p_remark, int p_mark,int sp_id) {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   stmt.executeUpdate("Update student_paper SET PSTATUS='Accepted',MARKS="+p_mark+" where sp_id="+sp_id); 
			   stmt.executeUpdate("Update paper_faculty SET REMARKS='"+p_remark+"' where sp_id="+sp_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		
	}
	public void declinetPublication(String p_remark,int sp_id) {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   stmt.executeUpdate("Update student_paper SET PSTATUS='Rejected'"+"where sp_id="+sp_id); 
			   stmt.executeUpdate("Update paper_faculty SET REMARKS='"+p_remark+"' where sp_id="+sp_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		
	}
	public void undoPublication(int sp_id,int fp_id) {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   stmt.executeUpdate("Update student_paper SET PSTATUS='Pending',MARKS=0"+" where sp_id="+sp_id); 
			   stmt.executeUpdate("Update paper_faculty SET REMARKS='No remarks' where pf_id="+fp_id); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		
	}   
	public ResultSet getTotalAcceptedPublications() {
		ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   return stmt.executeQuery("SELECT COUNT(*) FROM publication_portal.student_paper where PSTATUS='Accepted'"); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		  return rs2;
		
	}   	   
	public ResultSet getTotalRejectedPublications() {
		ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   return stmt.executeQuery("SELECT COUNT(*) FROM publication_portal.student_paper where PSTATUS='Rejected'"); 
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		  return rs2;
		
	} 
	
	public LoginObj login(String username,String password) {

		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   ResultSet rs2=stmt.executeQuery("Select PASS,ISFACULTY,L_ID,ISADMIN,SALT from login where USERNAME='"+username+"'");
			   while(rs2.next()) {
				   String pass=rs2.getString(1);
				   String isFaculty=rs2.getString(2);
				   int LID=rs2.getInt(3);
				   String isAdmin=rs2.getString(4);
				   String salt=rs2.getString(5);
				   int s_id=-1;
				   int f_id=-1;

			        String passwordToHash = password;
			        String securePassword = get_SHA_512_SecurePassword(passwordToHash, salt);
			        
			        
				   if(pass.equals(securePassword)) {
					   if(isFaculty.equals("No")) {
						   Statement stmt2=con.createStatement(); 
						   ResultSet rs4=stmt2.executeQuery("Select S_ID from student where L_ID='"+LID+"'");
						   rs4.next();
						   s_id=rs4.getInt(1);
					   }
					   else if(isFaculty.equals("Yes")) {
						   Statement stmt2=con.createStatement(); 
						   ResultSet rs4=stmt2.executeQuery("Select F_ID from faculty where L_ID='"+LID+"'");
						   rs4.next();
						   f_id=rs4.getInt(1);   
					   }
					   LoginObj lobj=new LoginObj(true,isFaculty,LID,isAdmin,s_id,f_id);
					   return lobj;
				   }
					   
				   else {
					   LoginObj lobj=new LoginObj(false,isFaculty,LID,isAdmin,s_id,f_id);
					   return lobj;
					  
				   }
			   }
			   
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   LoginObj lobj2=new LoginObj(false,"No",-1,"No",-1,-1);
		   return lobj2;
	}  
	   public void addForget(String username,String status)  {
		   
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   String sql3="Insert into forget_request(forget_request_status,forget_request_username) VALUES ('"+status+ "','"+ username+" '); ";
			   stmt.executeUpdate(sql3); 
		   }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		 
	   }
	   
	   public ResultSet getAdminForget()  {
		   ResultSet rs2=null;
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement();  
			   String sql3="Select * from forget_request ";
			   return stmt.executeQuery(sql3); 
		   }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
		   return rs2;
	   }
	   
	   public void editLogin(String username,String pass) {
		   try{  
			   Class.forName("com.mysql.jdbc.Driver");   
			   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/publication_portal","root","");
			   Statement stmt=con.createStatement(); 
			   stmt.executeUpdate("Update login SET PASS="+"'"+pass+"'"+" where USERNAME="+"'"+username+"'"); 
			   stmt.executeUpdate("Update forget_request SET forget_request_status='done'"+" where forget_request_username="+"'"+username+"'"); 
			   
			  }
		   	catch(Exception e){ 
		   		System.out.println(e);
		   	} 
	   }
	
}
