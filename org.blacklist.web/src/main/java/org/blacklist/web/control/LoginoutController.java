package org.blacklist.web.control;

import javax.servlet.http.HttpSession;

import org.blacklist.web.control.model.SearchInValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/loginout")

public class LoginoutController {

	@GetMapping
	public ModelAndView login(HttpSession httpSession) {
		
		
		httpSession.removeAttribute("errorLogin");
		httpSession.removeAttribute("user");
		httpSession.removeAttribute("successLogin");
		
		return new ModelAndView("search/home", "SearchInValue", new SearchInValue() );
		
	}
	
}
