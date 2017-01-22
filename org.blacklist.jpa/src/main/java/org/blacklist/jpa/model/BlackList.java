package org.blacklist.jpa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlackList {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String accountTypeId;
	private String account;
	private String accountCatalogId;
	private String score;
	private String scoreReason;
	private String scoreDesc;
	private String attachementId;
	private String attachementName;
	private String attachementUrl;
	private String isCharge;
	private BigDecimal chargeAmout;
	public BigDecimal getChargeRate() {
		return chargeRate;
	}

	private BigDecimal  chargeRate;
	private String recordAccount;
	
	
	public BlackList()
	{
		
	}
	

	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public void setChargeRate(BigDecimal chargeRate) {
		this.chargeRate = chargeRate;
	}
	

	public String getAccoutTypeId() {
		return accountTypeId;
	}

	public void setAccoutTypeId(String accoutTypeId) {
		this.accountTypeId = accoutTypeId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccountCatalogId() {
		return accountCatalogId;
	}

	public void setAccountCatalogId(String accountCatalogId) {
		this.accountCatalogId = accountCatalogId;
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

	public String getAttachementId() {
		return attachementId;
	}

	public void setAttachementId(String attachementId) {
		this.attachementId = attachementId;
	}

	public String getAttachementName() {
		return attachementName;
	}

	public void setAttachementName(String attachementName) {
		this.attachementName = attachementName;
	}

	public String getAttachementUrl() {
		return attachementUrl;
	}

	public void setAttachementUrl(String attachementUrl) {
		this.attachementUrl = attachementUrl;
	}

	public String getIsCharge() {
		return isCharge;
	}

	public void setIsCharge(String isCharge) {
		this.isCharge = isCharge;
	}

	public BigDecimal getChargeAmout() {
		return chargeAmout;
	}

	public void setChargeAmout(BigDecimal chargeAmout) {
		this.chargeAmout = chargeAmout;
	}



	public String getRecordAccount() {
		return recordAccount;
	}

	public void setRecordAccount(String recordAccount) {
		this.recordAccount = recordAccount;
	}


	


}
