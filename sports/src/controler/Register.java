package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;

import model.LoginModel;
@WebServlet("/Register")
public class Register extends HttpServlet 
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{  
	  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    
		    String name=request.getParameter("name");  
		    
		    String age=request.getParameter("age");  
		    String unencryptedPass=request.getParameter("pass"); 
		   // System.out.println(name+"  "+unencryptedPass);
		    
		   // String encryptedPass=null;
			try 
			{
				//encryptedPass = SecurePass.generate(unencryptedPass);
		        //System.out.println("encrypted password...."+encryptedPass);
		        //System.out.println("Update Status..");
		        
				if(LoginModel.addUser(name,age,unencryptedPass)>0)
				{  
				    RequestDispatcher rd=request.getRequestDispatcher("RegisterSuccess.jsp");  
				    rd.forward(request,response);  
				}  
				else
				{  
				    out.print("Sorry username or password error: User may already be registered");  
				    RequestDispatcher rd=request.getRequestDispatcher("index.html");  
				    rd.include(request,response);  
				}
				
				System.out.println("Update Status..");
				
			} catch (SQLException e) 
		    {
			
				e.printStackTrace();
			}  
		          
		    out.close();
		    LoginModel.closeConn();
	    }  

	
}
