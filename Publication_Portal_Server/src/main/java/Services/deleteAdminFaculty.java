package Services;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class deleteAdminFaculty  extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	{
	    try{
	        StringBuilder sb = new StringBuilder();
	        BufferedReader br = req.getReader();
	        String str = null;
	        while ((str = br.readLine()) != null) {
	            sb.append(str);
	            System.out.println(str);
	        }
	        JSONObject jObj = new JSONObject(sb.toString());
	        int faculty_id = jObj.getInt("fid");
	        int faculty_lid = jObj.getInt("lid");
	        utilities.Database d=new utilities.Database();
	        d.deleteAdminFaculty(faculty_id,faculty_lid);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		
	}
}
