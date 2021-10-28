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
			ResultSet fs=d.getEachStudent();

			while(fs.next()) {
					JSONObject obj = new JSONObject(); 
					obj.put("sID",fs.getInt(1));
					obj.put("name",fs.getString(2));
					obj.put("rollNo",fs.getString(3));
					obj.put("phoneNO",fs.getString(4));
					obj.put("email",fs.getString(5));
					obj.put("preRecord",fs.getInt(6));
					obj.put("isEligibleDist",fs.getString(7));
					obj.put("isELigibleGrace",fs.getString(8));
					obj.put("graceMarks",fs.getInt(9));
					obj.put("lID",fs.getString(10));
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
