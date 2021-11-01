package Services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class getEachStudentPublication extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();
		
		try {
			ResultSet fs=d.getEachStudentPublication(1);
			JSONArray array = new JSONArray();
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
