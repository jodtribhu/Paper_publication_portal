package Services;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class editFaculty extends HttpServlet{
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
	        int f_id = jObj.getInt("f_id");
	        String editname = jObj.getString("editname");
	        String editroll = jObj.getString("editroll");
	        String editdept = jObj.getString("editdept");
	        String editdesig = jObj.getString("editdesig");
	        String editcampus = jObj.getString("editcampus");
	        String editmobile = jObj.getString("editmobile");
	        String editemail = jObj.getString("editemail");
	        d.editFaculty(f_id,editname,editroll,editdept,editdesig,editcampus,editmobile,editemail);
	        
	        
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
}
