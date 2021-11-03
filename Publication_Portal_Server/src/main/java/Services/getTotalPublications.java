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

public class getTotalPublications extends HttpServlet{
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{			        	
		utilities.Database d=new utilities.Database();
		try {
			ResultSet fs=d.getTotalAcceptedPublications();
			ResultSet fs2=d.getTotalRejectedPublications();
			JSONObject obj = new JSONObject();
			while(fs.next()) {
				obj.put("accepted_count",fs.getInt(1));		
			}
			while(fs2.next()) { 
				obj.put("rejected_count",fs2.getInt(1));		
			}
		    res.setContentType("application/json");
		    res.setHeader("Cache-Control", "nocache");
		    res.setCharacterEncoding("utf-8");
		    PrintWriter out2 = res.getWriter(); 
		    out2.println(obj);
		    
		    
		} catch (SQLException e) {
			e.printStackTrace();
		}     
	}
}
