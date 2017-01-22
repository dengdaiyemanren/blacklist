package org.blacklist.jpa;

import java.util.List;

import org.blacklist.jpa.model.BlackList;
import org.blacklist.jpa.repository.BlackListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

/*	@Bean
	public String demo(BlackListRepository repository) {
		// save
		BlackList one = new BlackList();
		
		one.setAccount( new String("test111"));
		one.setScore("***");
		one.setScoreDesc("desc");
		repository.save(one);
		
		// fetch all customers
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (BlackList blackList : repository.findAll()) {
//			log.info(blackList.toString());
		}
		
		// find one
		List<BlackList> blackOne=   (List<BlackList>) repository.findByAccountAndScore("test111","***");
		log.info("xxxx",blackOne.get(0).getScore());
		
		
		return "11";
	}*/
}
