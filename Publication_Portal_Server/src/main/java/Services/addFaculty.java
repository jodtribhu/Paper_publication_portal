package Services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;


public class addFaculty extends HttpServlet
{
	
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
	        String fname = jObj.getString("fname");
	        String femail = jObj.getString("femail");
	        String fpassword = jObj.getString("fpassword");
	        d.addFaculty(fname,femail,fpassword);
	        	
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

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();
		try {
			ResultSet fs=d.getFaculty();
			JSONArray array = new JSONArray();
			while(fs.next()) {
				JSONObject obj = new JSONObject(); 
				obj.put("fID",fs.getInt(1));
				obj.put("name",fs.getString(2));
				obj.put("phoneNO",fs.getString(3));
				obj.put("email",fs.getString(5));
				obj.put("department",fs.getString(4));
				obj.put("lID",fs.getInt(6));
				System.out.println("Inside");
				array.put(obj);	
			}
			JSONObject obj2 = new JSONObject(); 	
			 obj2.put("f",array);
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
