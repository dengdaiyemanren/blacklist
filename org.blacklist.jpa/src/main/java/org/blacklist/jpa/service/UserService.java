package org.blacklist.jpa.service;

import java.util.List;

import org.blacklist.jpa.model.User;
import org.blacklist.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	@Transactional
	public void saveUser(User user)
	{
		userRepository.save(user);
	}
	
	@Transactional
	public List<User> getUser(User user)
	{
		return userRepository.findByLoginUserId(user.getLoginUserId());
	}
	

}
