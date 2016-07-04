package com.part.controller;

import java.io.File;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.part.domain.BOM;
import com.part.domain.ECN;
import com.part.domain.PLMXmlObjects;
import com.part.domain.Part;
import com.part.service.PartService;

@Controller
public class PartController {
	
	@Autowired PartService partService;
	
	Log log = LogFactory.getLog(getClass());

	@RequestMapping(value="/partcsv")
	@ResponseBody
	public String putPartCSV(Part partObj,Map<String, String> mapperObj){
		System.out.println("inside putpartcsv()");
		partService.putPartCSV(partObj, mapperObj);
		return "partcsv";
	}
	
	@RequestMapping(value="/partack/{item}")
	@ResponseBody
	public String getPartACK(@PathVariable String item){
		System.out.println("inside getpartcsv()");
		boolean result = partService.getPartAck(item);
		System.out.println("is data present:"+result);
		return "partack";
	}
	
	@RequestMapping(value="/xmltojavapart")
	@ResponseBody
	public PLMXmlObjects xmlToJavaObjPart(){
		log.info("part xml start read!!");
		PLMXmlObjects xmlObjects = null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(PLMXmlObjects.class);  
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        xmlObjects = (PLMXmlObjects) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\creddyga\\plm domain\\samplemessage.xml"));  
		}catch(Exception e){
			e.printStackTrace();
		}
		log.info("part xml end read!!");
		return xmlObjects;
	}
	
	@RequestMapping(value="/xmltojavabom")
	@ResponseBody
	public BOM xmlToJavaObjBOM(){
		log.info("bom xml start read!!");
		BOM bom = null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(BOM.class);  
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        bom = (BOM) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\creddyga\\plm domain\\ESIResponse_Update_BOM.xml"));  
		}catch(Exception e){
			e.printStackTrace();
		}
		log.info("bom xml end read!!");
		return bom;
	}
	
	@RequestMapping(value="/xmltojavaecn")
	@ResponseBody
	public ECN xmlToJavaObjECN(){
		log.info("ECN xml start read!!");
		ECN ecn = null;
		try{
		JAXBContext jaxbContext = JAXBContext.newInstance(ECN.class);  
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
        ecn = (ECN) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\creddyga\\plm domain\\ESIResponse_8_ecn_Part.xml"));  
		}catch(Exception e){
			e.printStackTrace();
		}
		log.info("ECN xml end read!!");
		return ecn;
	}
	
	@RequestMapping(value="/logfile")                  
	@ResponseBody
	public String sampleLog(){
		System.out.println("inside sampleLog()");
		log.info("logger file start");
		log.warn("warning message sample");
		log.error("logerror sample");
		log.info("logger file end");
		log.debug("debug proc");
		log.trace("trace file");
		log.fatal("fatal");
		return "logfile";
	}
	
	
}
