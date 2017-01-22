package org.blacklist.jpa.repository;

import java.util.List;

import org.blacklist.jpa.model.AccountCatalog;
import org.springframework.data.repository.CrudRepository;

public interface AccountCatalogRepository  extends CrudRepository<AccountCatalog,Long>{

	List<AccountCatalog> findByAccountCatalogId(String accountCatalogId);
}