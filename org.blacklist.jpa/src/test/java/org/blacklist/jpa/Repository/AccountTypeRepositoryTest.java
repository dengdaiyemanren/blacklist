package org.blacklist.jpa.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.blacklist.jpa.model.AccountType;
import org.blacklist.jpa.repository.AccountTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountTypeRepositoryTest {
	
	@Autowired
    private  AccountTypeRepository repository;
	

	@Test
	public void findByAccountTypeIdTest()
	{
		AccountType at = new AccountType();
		
		at.setAccountTypeId("test111");
		at.setAccountTypeName("testname");
		repository.save(at);
		
		List <AccountType>  result = repository.findByAccountTypeId("test111");
		
		assertThat(result.get(0).getAccountTypeName()).isEqualTo("testname");
		
		repository.delete(at);
	}
}
