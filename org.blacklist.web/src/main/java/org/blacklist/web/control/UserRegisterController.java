package org.blacklist.web.control;

import org.blacklist.jpa.model.User;
import org.blacklist.jpa.service.UserService;
import org.blacklist.web.control.model.RegisterInValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/register")

public class UserRegisterController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ModelAndView register() {
		
		return new ModelAndView("register/home", "RegisterInValue", new RegisterInValue() );
		
	}

	@PostMapping
	public ModelAndView saveRecordValue(RegisterInValue userInfo,BindingResult result,RedirectAttributes redirect)
	{
		
		User user = new User();
		
		user.setLoginUserId(userInfo.getLoginUserId());
		user.setLoginPassword(userInfo.getLoginPassword());
		user.setMobile(userInfo.getMobile());
		
		userService.saveUser(user);
		
		return new ModelAndView("register/result","result",null);
		
	
	}
}
