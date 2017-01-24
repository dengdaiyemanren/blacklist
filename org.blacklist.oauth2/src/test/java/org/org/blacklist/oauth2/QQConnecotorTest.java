package org.org.blacklist.oauth2;

import org.junit.Test;
import org.org.blacklist.oauth2.connector.QQConnector;

public class QQConnecotorTest {

	@Test
	public void getAuthCode()
	{
		String name ="name";
		String appKey ="http://127.0.0.1:8080";
		String appSecret ="appSecret";
		
		QQConnector qq = new QQConnector(name,appKey,appSecret);
		String authUrl = qq.createAuthorizeUrl("state");
		System.out.println(authUrl);
		
		
		
	}
}
