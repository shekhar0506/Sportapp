package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LoginModel;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{  
		  
			    response.setContentType("text/html");  
			    PrintWriter out = response.getWriter();  
			          
			    
			    String Fname=request.getParameter("Fname");
			    String Mname=request.getParameter("Mname");
			    String Lname=request.getParameter("Lname");
			    String phone=request.getParameter("phone");
			    String email=request.getParameter("email");
			    String address=request.getParameter("address");
			    String sports=request.getParameter("sports");  
			    
				try 
				{
			        
					if(LoginModel.profile(Fname,Mname,Lname,phone,email,address,sports)>0)
					{  
					    RequestDispatcher rd=request.getRequestDispatcher("RegisterSuccess.jsp");  
					    rd.forward(request,response);  
					}  
					else
					{  
					    out.print("Sorry enter proper details User may already be registered");  
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