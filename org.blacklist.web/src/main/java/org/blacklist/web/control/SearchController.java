package org.blacklist.web.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.blacklist.jpa.model.BlackList;
import org.blacklist.jpa.service.BlackListService;
import org.blacklist.web.control.model.LoginInValue;
import org.blacklist.web.control.model.SearchInValue;
import org.blacklist.web.control.model.SearchOutValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/search")
public class SearchController {

	private static Logger LOG = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private BlackListService searchService;
	
	
	
	@GetMapping
	public ModelAndView search(HttpSession httpSession)  {
		
		ModelAndView model = new ModelAndView();
		
		model.addObject("SearchInValue", new SearchInValue());
		//model.addObject("LoginInValue",new LoginInValue());
		
		//httpSession.setAttribute("loginFlag","false");
		
		//SearchAndLoginInValue value = new SearchAndLoginInValue();
		
		
		//return model.getModel().put("LoginInValue",value);
		return new ModelAndView("search/home", "SearchInValue", new SearchInValue() );
		
		//model.getModel().put("LoginInValue",new LoginInValue());
		
		
		
		
		
		//model.setViewName("search/home");
		
		//return model;
		//return new ModelAndView("search/home", "SearchInValue", new SearchInValue() );
	}
	
	@GetMapping(value = "/searchResult")
	public ModelAndView searchResult() {
		return new ModelAndView("search/home", "SearchInValue", new SearchInValue() );
	}
	
	
	@PostMapping(value = "/searchagain")
	public ModelAndView searchagain(SearchInValue searchInValue,BindingResult result,RedirectAttributes redirect) {
		
		
		List<BlackList> blackList = searchService.findByAccount(searchInValue.getSearchAccount());
		
		SearchOutValue out = new SearchOutValue();
		out.setSearchAccount(searchInValue.getSearchAccount());
		
		for(int i=0;i<blackList.size();i++)
		{
			SearchOutValue item = new SearchOutValue();
			item.setScore(blackList.get(i).getScore());
			item.setScoreDesc(blackList.get(i).getScoreDesc());
			item.setScoreReason(blackList.get(i).getScoreReason());
			item.setSearchAccount(blackList.get(i).getAccount());
			
			out.getResult().add(item);
			
		}
		
		
		return new ModelAndView("/search/result","result",out);
	}
	
	
/*	@GetMapping@RequestMapping("form")
	public ModelAndView searchIndex() {
		
		return new ModelAndView("forward:/search", "SearchInValue", "test" );
		
	}*/
	
	
	@PostMapping
	//@GetMapping(params = "form",method = RequestMethod.POST)
	//public String searchByKey(@ModelAttribute SearchInValue searchInValue)
	public ModelAndView searchByKey(SearchInValue searchInValue,BindingResult result,RedirectAttributes redirect)
	{
		
		//message = this.messageRepository.save(message);
		
		//redirect.addFlashAttribute("globalMessage", "Successfully created a new message");
	
		List<BlackList> blackList = searchService.findByAccount(searchInValue.getSearchAccount());
		
		SearchOutValue out = new SearchOutValue();
		out.setSearchAccount(searchInValue.getSearchAccount());
		
		for(int i=0;i<blackList.size();i++)
		{
			SearchOutValue item = new SearchOutValue();
			item.setScore(blackList.get(i).getScore());
			item.setScoreDesc(blackList.get(i).getScoreDesc());
			item.setScoreReason(blackList.get(i).getScoreReason());
			item.setSearchAccount(blackList.get(i).getAccount());
			
			out.getResult().add(item);
			
		}
		
		
		return new ModelAndView("search/result","result",out);
		 
		 //return "redirect:/search";
		
		// SearchInValue value =  new SearchInValue() ;
		/// value.setSearchAccount("xxx");
		 //return new ModelAndView("search/home", "SearchInValue", value);
		 
		 //return "redirect:/search";
		 
		// return new ModelAndView("search/home", "SearchInValue", value);
		
		/*//Iterable<Message> messages = this.messageRepository.findAll();
		SearchOutValue outValue = new SearchOutValue();
	
		List<BlackList> blackList = blackListRepository.findByAccount(searchValue.getSearchAccount());
		
		outValue.setScore(blackList.get(0).getScore());
		outValue.setSearchAccount(searchValue.getSearchAccount());
		
		return new ModelAndView("search/home", "SearchInValue", outValue );*/
	}
	/**
	@GetMapping("{searchInValue.key}")
    public ModelAndView getAccountInfo(@PathVariable String account) {
		
		SearchOutValue out = new SearchOutValue();
    	
    	out.setSearchAccount(account);
    	out.setScore("**");
    	out.setScoreDesc("xxxx");
    	
    	return null;
    }*/
    
}
