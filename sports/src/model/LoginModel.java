


package model;



import java.sql.*;

public class LoginModel {

	static java.sql.Connection con=null;
	 static PreparedStatement ps=null;
	 static ResultSet rs=null;
	
	 public static boolean validate(String name,String age,String pass) throws SQLException
    {
   	 boolean st=false;
   	 con=DBConnection.getDBCon();
   	 ps=con.prepareStatement( "select * from sports where  name=? and age=? and  pass=? ");  
   	 ps.setString(1,name); 
   	 
   	ps.setString(2,age); 
   	ps.setString(3,pass); 
   	  
   			       
   	 rs=ps.executeQuery();  
   	 st=rs.next();  
   	 return st;
   	
     }
	 
	public static int addUser(String name,String age,String pass) throws SQLException 
	{
		 int st=0;
		 con=DBConnection.getDBCon();
   	 ps=con.prepareStatement( "insert into sports values(?,?,?)");  
   	ps.setString(1,name); 
  	 
   	ps.setString(2,age); 
   	 
   	 ps.setString(3,pass);  

   	 st=ps.executeUpdate();
		 return st;
	} 
    
	//profile addition
	
	public static int profile(String Fname,String Mname,String Lname,String phone,String email,String address,String sports) throws SQLException 
	{
		 int st=0;
		 con=DBConnection.getDBCon();
   	 ps=con.prepareStatement( "insert into profile values(?,?,?,?,?,?,?)");  
   	ps.setString(1,Fname); 
  	 
   	ps.setString(2,Mname); 
   	 
   	 ps.setString( 3,Lname);
   	 ps.setString( 4,phone);
   	 ps.setString( 5,email);
   	 ps.setString( 6,address);
   	 ps.setString( 7,sports);

   	 st=ps.executeUpdate();
		 return st;
	} 
    
	
	
	
    public static void closeConn()
    {
   	 if(rs!=null)
	    	 {
	    	 try 
	    	 {
				rs.close();
			 }catch (SQLException e) {
		
				e.printStackTrace();}
	    	 }
   	 if(ps!=null)
	    	 {
	    	 try 
	    	 {
				ps.close();
			 }catch (SQLException e) {
		
				e.printStackTrace();}
	    	 }
   	 if(con!=null)
   	 {
	    	 try 
	    	 {
				con.close();
			 }catch (SQLException e) {
		
				e.printStackTrace();}
   	 }
    }
}
