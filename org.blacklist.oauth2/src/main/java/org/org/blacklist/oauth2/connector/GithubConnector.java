package org.org.blacklist.oauth2.connector;

import java.util.HashMap;

import org.org.blacklist.oauth2.OauthConnector;
import org.org.blacklist.oauth2.OauthUser;
import org.org.blacklist.oauth2.utils.HttpUtils;

/**
 * Copyright (c) 2015-2016, Michael Yang 杨福海 (fuhai999@gmail.com).
 *
 * Licensed under the GNU Lesser General Public License (LGPL) ,Version 3.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl-3.0.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import com.alibaba.fastjson.JSONObject;

public class GithubConnector extends OauthConnector {

	public GithubConnector(String name, String appkey, String appSecret) {
		super(name, appkey, appSecret);
	}
	@Override
	public String createAuthorizeUrl(String state) {
		StringBuilder sb = new StringBuilder("https://github.com/login/oauth/authorize?");
		sb.append("scope=user");
		sb.append("&client_id=" + getClientId());
		sb.append("&redirect_uri=" + getRedirectUri());
		sb.append("&state=" + state);

		return sb.toString();
	}

	@Override
	public OauthUser getOauthUser(String code) {
		String accessToken = getAccessToken(code);
		System.out.println("accessToken="+accessToken);
		
		String url = "https://api.github.com/user?access_token=" + accessToken;

		String httpString = HttpUtils.get(url);
		
		System.out.println("httpString="+httpString);
		
		JSONObject json = JSONObject.parseObject(httpString);

		OauthUser user = new OauthUser();
		user.setAvatar(json.getString("avatar_url"));
		user.setOpenId(json.getString("id"));
		user.setNickname(json.getString("login"));
		user.setSource(getName());

		return user;
	}

	public String getAccessToken(String code) {

		StringBuilder urlBuilder = new StringBuilder("https://github.com/login/oauth/access_token?");
		urlBuilder.append("client_id=" + getClientId());
		urlBuilder.append("&client_secret=" + getClientSecret());
		urlBuilder.append("&code=" + code);

		String url = urlBuilder.toString();

		String httpString = HttpUtils.post(url,new HashMap());
		
		System.out.println("accessToken2="+httpString);
		JSONObject json = new JSONObject ();
		
		String result [] = httpString.split("&");
		
		for(int i=0;i<result.length;i++)
		{
			String oneparam = result[i];
			
			String [] oneResult = oneparam.split("=");
			
			if(oneResult.length>=2)
			{
				json.put(oneResult[0], oneResult[1]);
			}
			else
			{
				json.put(oneResult[0], "");
			}
			
			
			
		}
		
		//JSONObject json = JSONObject.parseObject(httpString);
		return json.getString("access_token");
	}
}
