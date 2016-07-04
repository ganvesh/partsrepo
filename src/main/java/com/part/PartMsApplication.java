package com.part;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class PartMsApplication extends SpringBootServletInitializer {
	Log log = LogFactory.getLog(getClass());
	public static void main(String[] args) {
		SpringApplication.run(PartMsApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		log.info("logger file start");
		log.warn("warning message sample");
		log.error("logerror sample");
		log.info("logger file end");
		return builder.sources(PartMsApplication.class);
	}
	
}
