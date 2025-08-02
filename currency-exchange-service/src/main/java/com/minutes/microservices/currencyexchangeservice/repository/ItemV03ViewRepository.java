package com.minutes.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.minutes.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectHeader;
import com.minutes.microservices.currencyexchangeservice.view.ItemV03View;
import com.minutes.microservices.currencyexchangeservice.view.PurchaseOrderItemV03;

@EnableJpaRepositories
public interface ItemV03ViewRepository extends JpaRepository<ItemV03View, Long>{

}
