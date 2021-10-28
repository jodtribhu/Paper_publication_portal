package Services;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import utilities.XMLDocument;
import utilities.XMLTools;

public class addPublication extends HttpServlet{
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
	        String student_publication_title = jObj.getString("student_publication_title");
	        String student_publication_start = jObj.getString("student_publication_start");
	        String student_publication_link = jObj.getString("student_publication_link");
	        
	        String student_journal_name = jObj.getString("student_journal_name");
	        String student_conference_name = jObj.getString("student_conference_name");
	        
	        String student_publication_end = jObj.getString("student_publication_end");
	        String student_publication_submitdate = jObj.getString("student_publication_submitdate");
	        String student_publication_isimp = jObj.getString("student_publication_isimp");
	        String student_publication_issurv = jObj.getString("student_publication_issurv");
	        String student_publication_isconf = jObj.getString("student_publication_isconf");
	        String student_publication_isjor = jObj.getString("student_publication_isjor");
	        utilities.Database d=new utilities.Database();
	        d.addPublication(student_publication_title,student_publication_start,student_publication_link,student_journal_name,student_conference_name,student_publication_end,student_publication_submitdate,student_publication_isimp,student_publication_issurv,student_publication_isconf,student_publication_isjor);
	    	    
	        res.setContentType("application/json");
	        res.setHeader("Cache-Control", "nocache");
	        res.setCharacterEncoding("utf-8");
	        PrintWriter out = res.getWriter();
	        out.print("Successful");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }

		
	}
}
