package demo.app;

import java.sql.*;

public class DBOperations 
{
  public static void InsertData
  (String sno,String Name,String city,String Mobile) 
  {
	  try
	  {
	  Class.forName("oracle.jdbc.driver.OracleDriver");
	  Connection con=DriverManager.getConnection
			  ("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
	  PreparedStatement pst = con.prepareStatement
			  ("insert into students values(?,?,?,?)");
	  pst.setInt(1, Integer.parseInt(sno));
	  pst.setString(2, Name);
	  pst.setString(3, city);
	  pst.setString(4, Mobile);
	  int l=pst.executeUpdate();
	  if(l>0)
	  {
		  System.out.println(sno+" Inserted Successfully");
	  }
	  }
	  catch(Exception ex)
	  {
		  System.out.println(sno+" Fail to Insert");
		  ex.printStackTrace();
	  }
	  
  }
  public static ResultSet GetData()
  {
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","123456");
		  Statement stmt=con.createStatement();
		  ResultSet rs =stmt.executeQuery("select * from students;");
		  return rs;
	  }
	  catch(Exception ex)
	  {
		  return null;
	  }
  }
}
