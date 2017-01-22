package org.blacklist.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountCatalog {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	String accountCatalogId;
	String accountCatalogName;
	
	public String getAccountCatalogId() {
		return accountCatalogId;
	}
	public void setAccountCatalogId(String accountCatalogId) {
		this.accountCatalogId = accountCatalogId;
	}
	public String getAccountCatalogName() {
		return accountCatalogName;
	}
	public void setAccountCatalogName(String accountCatalogName) {
		this.accountCatalogName = accountCatalogName;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
