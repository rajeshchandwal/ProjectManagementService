package com.minutes.microservices.currencyexchangeservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minutes.microservices.currencyexchangeservice.dto.ProjectHeaderDto;
import com.minutes.microservices.currencyexchangeservice.dto.ProjectItemDto;
import com.minutes.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.minutes.microservices.currencyexchangeservice.service.ProjectManagementItemService;
import com.minutes.microservices.currencyexchangeservice.service.ProjectManagementService;
@RestController
@RequestMapping("/item")
public class ProjectManagementItemController {
	
	private ProjectManagementItemService projectManagementItemService;
	
	
public ProjectManagementItemController(ProjectManagementItemService projectManagementItemService) {
		super();
		this.projectManagementItemService = projectManagementItemService;
	}







	//	@Autowired
//	private CurrencyExchangeRepository repository;
//	
//
//	@GetMapping("/currency-exchange/from/{from}/to/{to}")
//	public CurrencyExchange retriveExchangeValue(@PathVariable String from,@PathVariable String to) {
//		
//		CurrencyExchange currencyExchange 	=repository.findByFromAndTo(from, to);
//		if(currencyExchange == null) {
//			throw new  RuntimeException("Unable to find data for "+from+" to "+to);
//		}
//
//		return currencyExchange;
//		
//	}
    @PostMapping("/saveItem")
	public void itemsSave(@RequestBody List<@Valid  ProjectItemDto> projectItemDto) {
		
   	projectManagementItemService.itemsSave(projectItemDto);
	}

}
