package com.part.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.stereotype.Service;

@Service
public class SymixUtil {

	public static Connection con = null;
	public static Statement stmt = null;
	public static ResultSet rs = null;
	public static PreparedStatement ps = null;
	public static Connection getConnection(){
		 try
		  {
		   Class.forName ("com.ddtek.jdbc.openedge.OpenEdgeDriver");
		   System.out.println("Driver loaded");
		   con = DriverManager.getConnection("jdbc:datadirect:openedge://c217u083.cg.na.jci.com:50963;DatabaseName=symix","E2Open","nepO2E01");
		   System.out.println("Connected");
		  }
		  catch (Exception e) {
			  e.printStackTrace();
			  }
		 return con;
		 }
	
	public static void closeConnection(Connection con, PreparedStatement ps, ResultSet rs){
		if(rs != null || ps != null || con != null){
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public static void closeConnection(Connection con, Statement stmt, ResultSet rs){
		if(rs != null || stmt != null || con != null){
			try{
				rs.close();
				stmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
