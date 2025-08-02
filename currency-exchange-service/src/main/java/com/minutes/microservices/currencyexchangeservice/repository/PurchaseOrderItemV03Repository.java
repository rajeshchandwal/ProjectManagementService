package com.minutes.microservices.currencyexchangeservice.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.minutes.microservices.currencyexchangeservice.dto.inter.POItemV03View;
import com.minutes.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectHeader;
import com.minutes.microservices.currencyexchangeservice.view.PurchaseOrderItemV03;

@EnableJpaRepositories
public interface PurchaseOrderItemV03Repository extends JpaRepository<PurchaseOrderItemV03, Long>{
	
	@Query("select vi.qty as quantity, vi.unitPrice as price from PurchaseOrderItemV03 vi where vi.flag = 'Y'")
	List<POItemV03View> getViewData(Pageable paging);

}
