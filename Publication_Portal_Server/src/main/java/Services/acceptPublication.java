package Services;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

public class acceptPublication extends HttpServlet{

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
	        String p_remark = jObj.getString("p_remark");
	        int p_mark = jObj.getInt("p_mark");
	        int SP_ID = jObj.getInt("SP_ID");
	        
	        d.acceptPublication(p_remark,p_mark,SP_ID);
	        	
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
