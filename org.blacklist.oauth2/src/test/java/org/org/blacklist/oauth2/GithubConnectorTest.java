package org.org.blacklist.oauth2;

import org.junit.Test;
import org.org.blacklist.oauth2.connector.GithubConnector;

public class GithubConnectorTest {

	@Test
	public void getAuthCode()
	{
		String name ="github";
		String appKey ="3001eb26d1ec8cb06cff";
		String appSecret ="025483b76bff72f52dc72b4643871e41d875bc95";
		
		GithubConnector githubconnector = new GithubConnector(name,appKey,appSecret);
		
		String statate = githubconnector.httpGet("https://github.com/login/oauth/authorize?client_id=3001eb26d1ec8cb06cff");
		
		/*String authUrl = qq.createAuthorizeUrl("state");
		System.out.println(authUrl);
		String authResult = qq.httpGet(authUrl);*/
		
		System.out.println("state="+statate);
	}
	
	
}
