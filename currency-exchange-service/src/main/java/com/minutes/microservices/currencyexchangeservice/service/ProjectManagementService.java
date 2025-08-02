package com.minutes.microservices.currencyexchangeservice.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minutes.microservices.currencyexchangeservice.dto.ProjectHeaderDto;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectHeader;
import com.minutes.microservices.currencyexchangeservice.repository.ProjectManagementHeaderRepository;

@Service
public class ProjectManagementService {
	
	

private ProjectManagementHeaderRepository projectManagementHeaderRepository;

public ProjectManagementService(ProjectManagementHeaderRepository projectManagementHeaderRepository) {

	this.projectManagementHeaderRepository = projectManagementHeaderRepository;
}


public void createProject(ProjectHeaderDto projectHeaderDto) {
	
	//projectManagementHeaderRepository.existsById(projectHeaderDto.getHeaderId());
	ProjectHeader projectHeader = new ProjectHeader();
	BeanUtils.copyProperties(projectHeaderDto, projectHeader);
	System.out.println("customer " +projectHeader.getCusomerName());
	projectManagementHeaderRepository.save(projectHeader);
}

public ProjectHeader getProject(Long id) {
	
	Optional<ProjectHeader> optionalHeader = projectManagementHeaderRepository.findById(id);
	ProjectHeader header = new ProjectHeader();
	if(optionalHeader.isPresent()) {
		header = optionalHeader.get();
	}
	return header;
}
	


}
