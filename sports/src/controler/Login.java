package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import java.io.*;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import model.LoginModel;

@WebServlet("/Login")
public class Login extends HttpServlet {

	
	static String encyptPass = null;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{  
	  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		   
		    String name=request.getParameter("name");
		    
		    String age=request.getParameter("phone");
		    
		    String unencryptedPass=request.getParameter("pass");  
		    try 
		    {
				//String encryptPass=SecurePass.generate(unencryptedPass);
				//System.out.println("Encrypted password: "+encryptPass);
				if(LoginModel.validate(name,age,unencryptedPass))
				{  
				    RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");  
				    rd.forward(request,response);  
				}  
				else{  
				    out.print("Sorry username or password error");  
				    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
				    rd.include(request,response);  
				}
			} 
		    
		    catch (SQLException e) 
		    {
				e.printStackTrace();
			}  
		          
		    out.close();
		    LoginModel.closeConn();
	    }  
	
	
	 
}
