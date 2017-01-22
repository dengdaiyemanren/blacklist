package org.blacklist.jpa.service;

import java.util.List;

import org.blacklist.jpa.model.AccountCatalog;
import org.blacklist.jpa.model.AccountType;
import org.blacklist.jpa.model.BlackList;
import org.blacklist.jpa.repository.AccountCatalogRepository;
import org.blacklist.jpa.repository.AccountTypeRepository;
import org.blacklist.jpa.repository.BlackListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlackListService {

	@Autowired
	BlackListRepository blackListRepository;
	
	@Autowired
	AccountTypeRepository accountTypeRepository;
	
	
	@Autowired
	AccountCatalogRepository accountCatalogRepository;
	
	
	@Transactional
	public List<AccountCatalog> findAllAccountCatalog()
	{
		return (List<AccountCatalog>) accountCatalogRepository.findAll();
	}
	
	@Transactional
	public List<AccountType> findAllAccountType()
	{
		return (List<AccountType>) accountTypeRepository.findAll();
	}
	
	@Transactional
	public List<BlackList> findByAccount(String accountId)
	{
		return blackListRepository.findByAccount(accountId);
		
	}
	
	@Transactional
	public void saveBlackListValue(BlackList blackList)
	{
		blackListRepository.save(blackList);
	}
	
}
