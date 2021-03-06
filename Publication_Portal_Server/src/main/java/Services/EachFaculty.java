package Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class EachFaculty extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();
		try {
			 StringBuilder sb = new StringBuilder();
		        BufferedReader br = req.getReader();
		        String str = null;
		        while ((str = br.readLine()) != null) {
		            sb.append(str);
		            System.out.println(str);
		        }
		        JSONObject jObj = new JSONObject(sb.toString());
		        int faculty_id = jObj.getInt("faculty_id");
		        int login_id = jObj.getInt("login_id");
		        
			ResultSet fs=d.getEachFaculty(login_id);
			while(fs.next()) {
				JSONObject obj = new JSONObject(); 
				obj.put("fID",fs.getInt(1));
				obj.put("name",fs.getString(2));
				obj.put("phoneNO",fs.getString(3));
				obj.put("IDNO",fs.getString(4));
				obj.put("department",fs.getString(5));
				obj.put("email",fs.getString(6));
				obj.put("designation",fs.getString(8));
				obj.put("campus",fs.getString(9));
			     res.setContentType("application/json");
			     res.setHeader("Cache-Control", "nocache");
			     res.setCharacterEncoding("utf-8");
			     PrintWriter out2 = res.getWriter(); 
			     out2.println(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}     
	}
}
