package Services;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class undoFacultyPublication extends HttpServlet{
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
	        int sp_id = jObj.getInt("SP_ID");
	        int pf_id = jObj.getInt("PF_ID");
	       
	        d.undoPublication(sp_id,pf_id);
	           
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
