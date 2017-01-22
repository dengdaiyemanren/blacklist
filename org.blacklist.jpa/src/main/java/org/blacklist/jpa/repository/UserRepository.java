package org.blacklist.jpa.repository;

import java.util.List;

import org.blacklist.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository  extends CrudRepository<User,Long>{
	List<User> findByLoginUserId(String loginUserId);
}
