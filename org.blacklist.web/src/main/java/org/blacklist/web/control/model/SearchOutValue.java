package org.blacklist.web.control.model;

import java.util.ArrayList;
import java.util.List;

public class SearchOutValue {
	
	String searchAccount;
	
	String score;
	String scoreDesc;
	String scoreReason;
	
	
	List<SearchOutValue> result = new ArrayList();
	
	
	public List<SearchOutValue> getResult() {
		return result;
	}
	public void setResult(List<SearchOutValue> result) {
		this.result = result;
	}

	
	public String getSearchAccount() {
		return searchAccount;
	}
	public void setSearchAccount(String searchAccount) {
		this.searchAccount = searchAccount;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getScoreDesc() {
		return scoreDesc;
	}
	public void setScoreDesc(String scoreDesc) {
		this.scoreDesc = scoreDesc;
	}
	public String getScoreReason() {
		return scoreReason;
	}
	public void setScoreReason(String scoreReason) {
		this.scoreReason = scoreReason;
	}

}
