package Services;

import java.io.BufferedReader;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class deleteAdminStudent extends HttpServlet{
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
	        int student_id = jObj.getInt("sid");
	        int student_lid = jObj.getInt("lid");
	        utilities.Database d=new utilities.Database();
	        d.deleteAdminStudent(student_id,student_lid);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		
	}
}
