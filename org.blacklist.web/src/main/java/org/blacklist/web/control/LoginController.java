package org.blacklist.web.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.blacklist.jpa.model.User;
import org.blacklist.jpa.service.UserService;
import org.blacklist.web.control.model.LoginInValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/login")

public class LoginController {

	@Autowired
	private UserService userService;
	
	
	@GetMapping
	public ModelAndView login(HttpSession httpSession) {
		
		
		/*httpSession.removeAttribute("errorLogin");
		httpSession.removeAttribute("user");
		httpSession.removeAttribute("successLogin");*/
		
		return new ModelAndView("login/home", "LoginInValue", new LoginInValue() );
		
	}
	@PostMapping
	public String login(LoginInValue LoginInValue,BindingResult result,RedirectAttributes redirect,HttpServletRequest req)
	{
		
		User user = new User();
		user.setLoginUserId(LoginInValue.getLoginUserId());
		
		List<User> userList = userService.getUser(user);
		
		String userName = LoginInValue.getLoginUserId();
		System.out.println("xxxx==="+userName);
		String pwd = (String) LoginInValue.getLoginPassword();
		
		
		if(null == userList || userList.size() == 0)
		{
			req.getSession().setAttribute("errorLogin", "用户名或者密码错误");
			req.getSession().removeAttribute("user");
			req.getSession().removeAttribute("successLogin");
			
			
			return "redirect:/login";
		}
		else
		{
			if(userList.get(0).getLoginUserId().equals(userName)&&userList.get(0).getLoginPassword().equals(pwd))
			{
				
				req.getSession().setAttribute("user", userName);
				req.getSession().setAttribute("successLogin", "欢迎你："+userName);
				req.getSession().removeAttribute("errorLogin");
				return "redirect:/search";
			}
			else
			{
				req.getSession().setAttribute("errorLogin", "用户名或者密码错误");
				req.getSession().removeAttribute("user");
				req.getSession().removeAttribute("successLogin");
				
				return "redirect:/login";
			}
			
			
		}
		
		//return new ModelAndView("redirect:/search/home","SearchInValue",new SearchInValue());
		
	}
	
	
	
}
