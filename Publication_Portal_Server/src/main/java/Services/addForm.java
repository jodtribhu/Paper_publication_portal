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

public class addForm extends HttpServlet {
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
	        String student_name = jObj.getString("student_name");
	        String student_roll_no = jObj.getString("student_roll_no");
	        String student_email = jObj.getString("student_email");
	        String student_publication_title = jObj.getString("student_publication_title");
	        String student_publication_start = jObj.getString("student_publication_start");
	        String student_publication_link = jObj.getString("student_publication_link");

	        String student_journal_name = jObj.getString("student_journal_name");
	        String student_conference_name = jObj.getString("student_conference_name");
	        JSONArray  team_mates = jObj.getJSONArray("team_mates");
	        for (int i = 0; i < team_mates.length(); i++) {
	            String team_name = team_mates.getString(i);
	            System.out.println(team_name);
//	            String team_roll = team_mates.getString("RollNo");
//	            String team_email= team_mates.getString("Email");
	          }
	              	
	        JSONObject json = new JSONObject();
	        res.setContentType("application/json");
	        res.setHeader("Cache-Control", "nocache");
	        res.setCharacterEncoding("utf-8");
	        PrintWriter out = res.getWriter();
	        out.print(json.toString());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
		
		try {
			XMLDocument xd=XMLTools.parseXML(req.getInputStream());
			System.out.println(xd.getAttributeValue("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
