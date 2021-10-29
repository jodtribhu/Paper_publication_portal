package Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import utilities.Database;

public class addStudent extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		utilities.Database d=new utilities.Database();
	    try{
	        StringBuilder sb = new StringBuilder();
	        BufferedReader br = req.getReader();
	        String str = null;
	        while ((str = br.readLine()) != null) {
	            sb.append(str);
	            System.out.println(str);
	        }
	        JSONObject jObj = new JSONObject(sb.toString());
	        String stuname = jObj.getString("stu_name");
	        String stu_roll= jObj.getString("stu_roll");
	        String stupassword = jObj.getString("stu_pass");
	       
	        d.addStudent(stuname,stu_roll,stupassword);
	        
	        
	        JSONObject json = new JSONObject();
	        res.setContentType("application/json");
	        res.setHeader("Cache-Control", "nocache");
	        res.setCharacterEncoding("utf-8");
	        PrintWriter out = res.getWriter();
	        out.print(json.toString());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		
	}
//	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
//	{			        	
//			utilities.Database d=new utilities.Database();
//			try {
//				ResultSet fs=d.getStudent();
//				JSONArray array = new JSONArray();
//				while(fs.next()) {
//					JSONObject obj = new JSONObject(); 
//
//					obj.put("sID",fs.getInt(1));
//					obj.put("name",fs.getString(2));
//					obj.put("rollNo",fs.getString(3));
//					obj.put("phoneNO",fs.getString(11));
//					obj.put("email",fs.getString(4));
//					obj.put("graceMarks",fs.getInt(6));
//					obj.put("campus",fs.getString(8));
//					obj.put("sex",fs.getString(9));
//					obj.put("phoneno",fs.getString(10));
//					obj.put("department",fs.getString(11));
//
//					array.put(obj);	
//				}
//				JSONObject obj2 = new JSONObject(); 	
//				 obj2.put("students",array);
//			     PrintWriter out2 = res.getWriter(); 
//			     out2.println(obj2);
//
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//	}
}
