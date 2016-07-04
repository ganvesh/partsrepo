package com.part.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetFromSymix {
	
	
	public static void main(String arg[])
	{
		 try
				  {
				        
				   Class.forName ("com.ddtek.jdbc.openedge.OpenEdgeDriver");
				   System.out.println("Driver loaded");
				   Connection con = DriverManager.getConnection("jdbc:datadirect:openedge://c217u083.cg.na.jci.com:50963;DatabaseName=symix","E2Open","nepO2E01");
				   System.out.println("Connected");
				   Statement stmt = con.createStatement();
				   System.out.println("Statement created");
				   ResultSet rs = stmt.executeQuery("SELECT buyer FROM  po");
				   System.out.println("ResultSet : \n");
				   while (rs.next())
				   {
				   // System.out.println(rs.getInt("po-num"));
				    //System.out.println(rs.getInt("vend-num"));
				    System.out.println(rs.getString("buyer"));
				   }
				   rs.close();
				   stmt.close();
				   con.close();
				  }
				  catch (Exception x) {x.printStackTrace();}
				 } 


}
