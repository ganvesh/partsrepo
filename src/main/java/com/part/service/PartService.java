package com.part.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.part.dao.PartDAO;
import com.part.domain.Part;

import au.com.bytecode.opencsv.CSVWriter;

@Service
public class PartService {

	 @Autowired PartDAO partDAO;
	 
	 public void putPartCSV(Part partObj,Map<String, String> mapperObj){
			System.out.println("inside putpartcsv service.");
			CSVWriter writer;
			try {
				writer = new CSVWriter(new FileWriter("c:\\yourfile.csv"), '\t');
				// feed in your array (or convert your data to an array)
			     String[] entries = "first#second#third".split("#");
			     writer.writeNext(entries);
				 writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			partDAO.putPartCSV();
	 }
		
	 public boolean getPartAck(String item){
			System.out.println("inside getPartAck service.");
		return partDAO.getPartAck(item);
	 }
}
