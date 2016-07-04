package com.part.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartDAO {

	@Autowired SymixUtil symixUtil;
	
	public void putPartCSV(){
		System.out.println("inside putpartcsv dao.");
	}
	
	@SuppressWarnings("static-access")
	public boolean getPartAck(String item){
		boolean result = false;
		System.out.println("inside getPartAck dao.");
		try{
		Connection con = symixUtil.getConnection();
		//Statement stmt = con.createStatement();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM item WHERE item = ?");
		ps.setString(1, item);
		ResultSet rs =ps.executeQuery();
		//ResultSet rs = stmt.executeQuery("SELECT * FROM item WHERE item ="+item);
		 System.out.println("ResultSet :");
		 int count = 0;
		   while (rs.next())
		   {
			count++;
		    System.out.println(rs.getString("item")+" "+rs.getString("description"));
		   }
		   if(count != 0){
			   result = true;
		   }
		 symixUtil.closeConnection(con, ps, rs);
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}
		return result;
	}
}
