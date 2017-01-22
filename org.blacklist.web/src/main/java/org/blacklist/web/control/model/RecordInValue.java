package org.blacklist.web.control.model;

import java.util.List;

import org.blacklist.jpa.model.AccountCatalog;
import org.blacklist.jpa.model.AccountType;

public class RecordInValue {
	
	private String accountCatalogId;

	private List<AccountCatalog> allAccountCatalog;
	

	private List<AccountType> allAccountType;
	
	private String accountTypeId;
	

	private String account;
	
	
	private String score;
	private String scoreReason;
	private String scoreDesc;
	
	public String getAccountCatalogId() {
		return accountCatalogId;
	}
	public void setAccountCatalogId(String accountCatalogId) {
		this.accountCatalogId = accountCatalogId;
	}
	public String getAccountTypeId() {
		return accountTypeId;
	}
	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getScoreReason() {
		return scoreReason;
	}
	public void setScoreReason(String scoreReason) {
		this.scoreReason = scoreReason;
	}
	public String getScoreDesc() {
		return scoreDesc;
	}
	public void setScoreDesc(String scoreDesc) {
		this.scoreDesc = scoreDesc;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	
	public List<AccountCatalog> getAllAccountCatalog() {
		return allAccountCatalog;
	}
	public void setAllAccountCatalog(List<AccountCatalog> allAccountCatalog) {
		this.allAccountCatalog = allAccountCatalog;
	}
	
	public List<AccountType> getAllAccountType() {
		return allAccountType;
	}
	public void setAllAccountType(List<AccountType> allAccountType) {
		this.allAccountType = allAccountType;
	}
}
