package com.minutes.microservices.currencyexchangeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minutes.microservices.currencyexchangeservice.dto.ProjectHeaderDto;
import com.minutes.microservices.currencyexchangeservice.dto.ProjectItemDto;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectHeader;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectItem;
import com.minutes.microservices.currencyexchangeservice.repository.ProjectManagementHeaderRepository;
import com.minutes.microservices.currencyexchangeservice.repository.ProjectManagementItemRepository;

@Service
public class ProjectManagementItemService {
	
	

private ProjectManagementItemRepository projectManagementItemRepository;
;

private ProjectManagementHeaderRepository projectManagementHeaderRepository;





public ProjectManagementItemService(ProjectManagementItemRepository projectManagementItemRepository,
		ProjectManagementHeaderRepository projectManagementHeaderRepository) {
	super();
	this.projectManagementItemRepository = projectManagementItemRepository;
	this.projectManagementHeaderRepository = projectManagementHeaderRepository;
}


public void itemsSave(List<ProjectItemDto> projectItemDto) {
	
//	projectManagementHeaderRepository.existsById(projectHeaderDto.getHeaderId());
	


	List<ProjectItem> projectItemList = projectItemDto.stream().map(itemDto ->{
		ProjectHeader projectHeader = new ProjectHeader();
		projectHeader.setHeaderId(itemDto.getHeaderId());
		
		ProjectItem projectItem = new ProjectItem();
		projectItem.setHeader(projectHeader);
		BeanUtils.copyProperties(itemDto, projectItem);
		return projectItem;
		
	}).toList();
//	BeanUtils.copyProperties(projectItemDto, projectHeader);
//	System.out.println("customer " +projectHeader.getCusomerName());
	projectManagementItemRepository.saveAll(projectItemList);
}




	


}
