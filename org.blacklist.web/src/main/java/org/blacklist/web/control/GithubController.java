package org.blacklist.web.control;

import javax.servlet.http.HttpServletRequest;

import org.org.blacklist.oauth2.OauthUser;
import org.org.blacklist.oauth2.connector.GithubConnector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/githubcallback")

public class GithubController {
	
	@GetMapping
	public String callback(HttpServletRequest httpRequst) {
		
		System.out.println("code="+httpRequst.getParameter("code"));
		String code = (String) httpRequst.getParameter("code");
		
		String name ="github";
		String appKey ="3001eb26d1ec8cb06cff";
		String appSecret ="025483b76bff72f52dc72b4643871e41d875bc95";
		
		GithubConnector githubconnector = new GithubConnector(name,appKey,appSecret);
		
		OauthUser user = githubconnector.getOauthUser(code);
		
		httpRequst.getSession().setAttribute("user",user.getNickname() );
		httpRequst.getSession().setAttribute("successLogin", "欢迎你："+user.getNickname());
		httpRequst.getSession().removeAttribute("errorLogin");
		
		return "redirect:/search";
		
	}
	

}
