package org.blacklist.jpa.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.blacklist.jpa.model.BlackList;
import org.blacklist.jpa.repository.BlackListRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlackListRepositoryTest {
	
	@Autowired
    private  BlackListRepository repository;
	
	
	@Test
	public void findByAccountTest()
	{
		BlackList blackList = new BlackList();
		
		blackList.setAccount("TEST111");
		blackList.setScore("**");
		blackList.setScoreReason("OOO");
	
		repository.save(blackList);
		
		
		List<BlackList> result = repository.findByAccount("TEST111");
		
		assertThat(result.get(0).getScore()).isEqualTo("**");
		assertThat(result.get(0).getScoreReason()).isEqualTo("OOO");
		
		//repository.delete(blackList);
		
		
	}
}
