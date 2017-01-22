package org.blacklist.jpa.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.blacklist.jpa.model.AccountCatalog;
import org.blacklist.jpa.repository.AccountCatalogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountCatalogRepositoryTest {

	@Autowired
    private  AccountCatalogRepository repository;
	
	@Test
	public void findByAccountCatalogIdTest()
	{
		AccountCatalog catalog = new AccountCatalog();
		catalog.setAccountCatalogName("test11");
		catalog.setAccountCatalogId("TEST111");
		repository.save(catalog);
		
		List <AccountCatalog>  result = repository.findByAccountCatalogId("TEST111");
		
		assertThat(result.get(0).getAccountCatalogName()).isEqualTo("test11");
		
		repository.delete(catalog);
		
	}
	
}
