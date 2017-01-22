package org.blacklist.jpa.repository;

import java.util.List;

import org.blacklist.jpa.model.AccountType;
import org.springframework.data.repository.CrudRepository;

public interface AccountTypeRepository extends CrudRepository<AccountType,Long>{
	
	
	List<AccountType> findByAccountTypeId(String accountTypeId);

}
