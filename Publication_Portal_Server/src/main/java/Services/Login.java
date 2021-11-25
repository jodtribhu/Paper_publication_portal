package Services;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import utilities.LoginObj;

public class Login extends HttpServlet{
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
	        String uname = jObj.getString("uname");
	        String password = jObj.getString("password");
	        
	        LoginObj lobj=d.login(uname,password);
	        	
	        
	
	        res.setHeader("Access-Control-Allow-Origin", "*");
	        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PATCH, DELETE, OPTIONS");
	 
	        
	        System.out.println("Is it Undefined"+lobj.getIsLoggedIn());
			JSONObject obj2 = new JSONObject(); 	
			obj2.put("logged_in",lobj.getIsLoggedIn());
			obj2.put("isFaculty",lobj.getIsFaculty());
			obj2.put("isAdmin", lobj.getIsAdmin());
			obj2.put("LID",lobj.getLID());
		    PrintWriter out2 = res.getWriter(); 
		    out2.println(obj2);
		    			
		
		
    
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	}

}
