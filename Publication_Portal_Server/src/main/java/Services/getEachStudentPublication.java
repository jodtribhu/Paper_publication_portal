package Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

public class getEachStudentPublication extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();
		HttpSession session=req.getSession();
		System.out.println(" getEachStudentPublication "+session.getAttribute("isFaculty"));
		try {
	        StringBuilder sb = new StringBuilder();
	        BufferedReader br = req.getReader();
	        String str = null;
	        while ((str = br.readLine()) != null) {
	            sb.append(str);
	            System.out.println(str);
	        }
	        JSONObject jObj = new JSONObject(sb.toString());
	        int student_id = jObj.getInt("student_id");
	        int login_id = jObj.getInt("login_id");
	        System.out.println("STUDENT ID" +student_id+" LOGIN_ID "+login_id);
			ResultSet fs=d.getEachStudentPublication(student_id);
			JSONArray array = new JSONArray();
			JSONArray array2 = new JSONArray();
			while(fs.next()) {
				JSONObject obj = new JSONObject(); 
				obj.put("PID",fs.getInt(1));
				obj.put("title",fs.getString(2));
				obj.put("startdate",fs.getString(3));
				obj.put("endadate",fs.getString(4));
				obj.put("scp_index",fs.getString(5));
				obj.put("is_Jo",fs.getString(6));
				obj.put("is_con",fs.getString(7));
				obj.put("jname",fs.getString(8));
				obj.put("cname",fs.getString(9));
				obj.put("is_sur",fs.getString(10));
				obj.put("is_imp",fs.getString(11));
				
				obj.put("is_eligible_dist",fs.getString(12));
				obj.put("is_eligible_grace",fs.getString(13));
				obj.put("link",fs.getString(14));
				obj.put("s_date",fs.getString(15));
				obj.put("is_claimed",fs.getString(19));
				obj.put("marks",fs.getString(20));
				obj.put("p_status",fs.getString(21));
				obj.put("sp_id",fs.getInt(16));
				
				
				//TeamMates
				 array2 = new JSONArray();
		
				
				ResultSet fs4=d.getEachStudentPublicationTeamStatus(fs.getInt(1));
				while(fs4.next()) {
			
					ResultSet fs5=d.getEachMateName(fs4.getInt(2));
					JSONObject obj3 = new JSONObject();
					while(fs5.next()) {
					obj3.put("mate_name",fs5.getString(1));
					obj3.put("mate_id",fs5.getString(2));
					obj3.put("mate_status",fs4.getString(6));
					obj3.put("mate_claimed_status",fs4.getString(4));
					}
					array2.put(obj3);
				}
				obj.put("team",array2);
				array.put(obj);	
			}
			
			
			JSONObject obj2 = new JSONObject(); 	
			obj2.put("publications",array);
	
		    res.setContentType("application/json");
		    res.setHeader("Cache-Control", "nocache");
		    res.setCharacterEncoding("utf-8");
		    PrintWriter out2 = res.getWriter(); 
		    out2.println(obj2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
	}
}
