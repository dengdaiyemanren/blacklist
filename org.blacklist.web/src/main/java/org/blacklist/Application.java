package org.blacklist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

	private static Logger LOG = LoggerFactory.getLogger(Application.class);
/*	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	@RequestMapping("/test")
	String test() {
		return "Hello World!11";
	}*/
	
	public static void main(String[] args) throws Exception {
		//LOG.error("test111");
		SpringApplication.run(Application.class, args);
	}



	
}