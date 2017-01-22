package org.blacklist.web.control;

import java.util.ArrayList;
import java.util.List;

import org.blacklist.jpa.model.AccountCatalog;
import org.blacklist.jpa.model.BlackList;
import org.blacklist.jpa.service.BlackListService;
import org.blacklist.web.control.model.RecordInValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value="/record")

public class RecordBlackListController {

	//private static Logger LOG = LoggerFactory.getLogger(RecordBlackListController.class);
	
	@Autowired
	private BlackListService searchService;
	
	
	@GetMapping
	public ModelAndView record() {
		
		RecordInValue value = new RecordInValue();
		//value.setAccountCatalogId("t11222333");
		
		AccountCatalog listone = new AccountCatalog();
		
		listone.setAccountCatalogId("test11");
		listone.setAccountCatalogName("企业");
		
		List list = new ArrayList();
		list.add(listone);
		
		value.setAllAccountCatalog(searchService.findAllAccountCatalog());
		value.setAllAccountType(searchService.findAllAccountType());
		
		
		//model.setViewName("record/home");
		
		//model.addObject(model);
		//model.addObject("RecordInValue", model);
		
		//return model;
		return new ModelAndView("record/home", "RecordInValue", value );
	}
	
	@PostMapping
	public ModelAndView saveRecordValue(RecordInValue recordInValue,BindingResult result,RedirectAttributes redirect)
	{
		
		BlackList blackList = new BlackList();
		blackList.setAccountCatalogId(recordInValue.getAccountCatalogId());
		blackList.setAccoutTypeId(recordInValue.getAccountTypeId());
		blackList.setAccount(recordInValue.getAccount());
		blackList.setScore(recordInValue.getScore());
		blackList.setScoreDesc(recordInValue.getScoreDesc());
		blackList.setScoreReason(recordInValue.getScoreReason());
		
		blackList.setAccount(recordInValue.getAccountCatalogId());
		
		
		searchService.saveBlackListValue(blackList);
		
		
		return new ModelAndView("record/result","result",null);
	
	}

}
