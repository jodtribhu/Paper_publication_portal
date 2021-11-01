package Services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class EachStudent extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();
		try {
			ResultSet fs=d.getEachStudent(1);

			while(fs.next()) {
					JSONObject obj = new JSONObject(); 
					obj.put("sID",fs.getInt(1));
					obj.put("name",fs.getString(2));
					obj.put("rollNo",fs.getString(3));
				
					obj.put("email",fs.getString(4));
					obj.put("graceMarks",fs.getInt(6));
					obj.put("campus",fs.getString(8));
					obj.put("sex",fs.getString(9));
					obj.put("phoneno",fs.getString(10));
					obj.put("department",fs.getString(11));
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
