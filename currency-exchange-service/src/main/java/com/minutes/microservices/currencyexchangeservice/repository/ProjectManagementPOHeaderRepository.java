package com.minutes.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.minutes.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectHeader;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectItem;
import com.minutes.microservices.currencyexchangeservice.entity.PurchaseOrderHeader;

@Repository
public interface ProjectManagementPOHeaderRepository extends JpaRepository<PurchaseOrderHeader, Long>{
	
}
