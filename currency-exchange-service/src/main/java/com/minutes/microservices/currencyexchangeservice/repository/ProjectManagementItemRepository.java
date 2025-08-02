package com.minutes.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minutes.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectHeader;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectItem;

@Repository
public interface ProjectManagementItemRepository extends JpaRepository<ProjectItem, Long>{
	
}
