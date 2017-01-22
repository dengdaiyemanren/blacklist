package org.blacklist.jpa.Repository;

import java.util.List;

import org.blacklist.jpa.model.User;
import org.blacklist.jpa.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository userRepository;
	
	@Test
	public void findByLoginUserIdTest() throws Exception 
	{
		User user = new User();
		user.setLoginUserId("test111");
		user.setMobile("11111");
		
		userRepository.save(user);
		List<User> userList = userRepository.findByLoginUserId("test111");
		
		Assert.assertEquals("11111", userList.get(0).getMobile());
		
		userRepository.delete(user);
		
	}
	
}
