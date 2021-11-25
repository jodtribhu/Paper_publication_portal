package Services;

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

public class getEachFacultyPublication extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();

		try {
			ResultSet fs=d.getEachFacultyPublication(2);
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
				obj.put("PF_ID",fs.getInt(16));
				obj.put("SP_ID",fs.getInt(19));
				obj.put("remarks",fs.getString(20));
				obj.put("S_ID",fs.getInt(22));
				
				
				obj.put("is_claimed",fs.getString(24));
				obj.put("marks",fs.getString(25));
				obj.put("p_status",fs.getString(26));
			
				obj.put("name",fs.getString(28));
				obj.put("rollNo",fs.getString(29));
			
				obj.put("email",fs.getString(30));
				
				obj.put("campus",fs.getString(34));
				obj.put("phoneno",fs.getString(36));
				obj.put("department",fs.getString(37));
				
				
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
