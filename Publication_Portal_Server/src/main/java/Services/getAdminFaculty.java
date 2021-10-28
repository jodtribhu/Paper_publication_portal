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

public class getAdminFaculty extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();
		try {
			ResultSet fs=d.getAdminFaculty();
			JSONArray array = new JSONArray();
			while(fs.next()) {
					JSONObject obj = new JSONObject(); 
					int loginid=fs.getInt(1);
					obj.put("lid",fs.getInt(1));
					obj.put("rollNo",fs.getString(2));
					obj.put("created_at",fs.getString(6));
					obj.put("modified_at",fs.getString(7));
					
					ResultSet fs2=d.getEachFaculty(loginid);

					fs2.next();
					obj.put("fID",fs2.getInt(1));
					obj.put("name",fs2.getString(2));
					obj.put("phoneNO",fs2.getString(3));
					obj.put("IDNO",fs2.getString(4));
					obj.put("department",fs2.getString(5));
					obj.put("email",fs2.getString(6));
					obj.put("designation",fs2.getString(9));
					obj.put("campus",fs2.getString(10));
					array.put(obj);	
				
			}
		    res.setContentType("application/json");
		    res.setHeader("Cache-Control", "nocache");
		    res.setCharacterEncoding("utf-8");
			JSONObject obj2 = new JSONObject(); 	
			obj2.put("adminfaculty",array);
		    PrintWriter out2 = res.getWriter(); 
		    out2.println(obj2);
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}     
	}
}
