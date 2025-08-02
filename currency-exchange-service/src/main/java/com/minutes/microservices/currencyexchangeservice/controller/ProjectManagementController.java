package com.minutes.microservices.currencyexchangeservice.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minutes.microservices.currencyexchangeservice.dto.ProjectHeaderDto;
import com.minutes.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectHeader;
import com.minutes.microservices.currencyexchangeservice.exception.ProjectItemExceptionHandler;
import com.minutes.microservices.currencyexchangeservice.exception.ProjectItemNotFoundException;
import com.minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.minutes.microservices.currencyexchangeservice.service.ProjectManagementService;
@RestController
@RequestMapping("/project")
public class ProjectManagementController {
	
	private ProjectManagementService projectManagementService;
	
	private MessageSource messageSource;

	
public ProjectManagementController(ProjectManagementService projectManagementService, MessageSource messageSource) {
		super();
		this.projectManagementService = projectManagementService;
		this.messageSource = messageSource;
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
    @PostMapping("/createProject")
	public String createProject(@Valid @RequestBody ProjectHeaderDto projectHeaderDto) {
		
		projectManagementService.createProject(projectHeaderDto);
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		//
		/***
		 * Example 'en' - English(Good Morning)
		 *         'nl' - Dutch(Goedemorgen)
		 */
	}
    @GetMapping("/fetchProject")
    public ProjectHeader getProject(@RequestParam("id") Long id) {
    	
    	ProjectHeader header =projectManagementService.getProject(id);
    	if(ObjectUtils.isEmpty(header)) {
    		throw new ProjectItemNotFoundException("Project Not Found");
    	}
    	
		return header;
    }

}
