package org.blacklist.jpa.repository;

import java.util.List;

import org.blacklist.jpa.model.BlackList;
import org.springframework.data.repository.CrudRepository;


public interface  BlackListRepository extends CrudRepository<BlackList,Long> {
	
	List<BlackList> findByAccount(String accountId);
	List<BlackList> findByAccountAndScore(String accountId,String score);
}
