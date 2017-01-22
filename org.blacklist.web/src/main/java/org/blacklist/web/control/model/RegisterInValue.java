package org.blacklist.web.control.model;

public class RegisterInValue {
	
	
	String loginType;
	String loginUserId;
	String loginPassword;

	String loginPassword2;
	
	String isFrom3rd;
	String mobile;
	
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getIsFrom3rd() {
		return isFrom3rd;
	}
	public void setIsFrom3rd(String isFrom3rd) {
		this.isFrom3rd = isFrom3rd;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginPassword2() {
		return loginPassword2;
	}
	public void setLoginPassword2(String loginPassword2) {
		this.loginPassword2 = loginPassword2;
	}

}
