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

public class getAdminForget extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();

		try {
			ResultSet fs=d.getAdminForget();
			JSONArray array = new JSONArray();
			while(fs.next()) {
					JSONObject obj = new JSONObject(); 
					obj.put("fid",fs.getInt(1));
					obj.put("f_status",fs.getString(2));
					obj.put("f_username",fs.getString(3));

					array.put(obj);	
				
			}
		    res.setContentType("application/json");
		    res.setHeader("Cache-Control", "nocache");
		    res.setCharacterEncoding("utf-8");
			JSONObject obj2 = new JSONObject(); 	
			obj2.put("adminforget",array);
		    PrintWriter out2 = res.getWriter(); 
		    out2.println(obj2);
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}     
	}
}
