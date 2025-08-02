package com.minutes.microservices.currencyexchangeservice.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.minutes.microservices.currencyexchangeservice.dto.ProjectHeaderDto;
import com.minutes.microservices.currencyexchangeservice.dto.PurchaseOrderHeaderDto;
import com.minutes.microservices.currencyexchangeservice.dto.inter.POItemV03ViewDto;
import com.minutes.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.minutes.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.minutes.microservices.currencyexchangeservice.response.ResponseHandler;
import com.minutes.microservices.currencyexchangeservice.service.ProjectManagementPurchaseOrderService;
import com.minutes.microservices.currencyexchangeservice.service.ProjectManagementService;
import com.minutes.microservices.currencyexchangeservice.view.PurchaseOrderItemV03;
import com.minutes.microservices.currencyexchangeservice.view.ItemV03View;
@RestController
@RequestMapping("/purchaseOrder")
public class ProjectManagementPurchaseOrderController {
	
	private ProjectManagementPurchaseOrderService projectManagementPurchaseOrderService;
	

public ProjectManagementPurchaseOrderController(
			ProjectManagementPurchaseOrderService projectManagementPurchaseOrderService) {
		super();
		this.projectManagementPurchaseOrderService = projectManagementPurchaseOrderService;
	}

    @PostMapping("/createPurchaseOrder")
	public void createPurchaseOrder(@RequestBody List<PurchaseOrderHeaderDto> purchaseOrderList, 
			@RequestParam("projectId") Long projectId) throws IOException {
		
    	projectManagementPurchaseOrderService.createPurchaseOrder(purchaseOrderList,projectId);
	}
    
    @GetMapping("/createPurchaseOrderItemView")
    public ResponseEntity<Object> getPurchaseOrderItems() {
    	List<PurchaseOrderItemV03> list =  	projectManagementPurchaseOrderService.getPurchaseOrderView();
    	
    	
     return 	ResponseHandler.responseBuilder("PurchaseOrder fetched successfully", HttpStatus.OK, list);
    	
    }
    
    @GetMapping("/itemView")
    public ResponseEntity<Object> getItemView() {
    	List<ItemV03View> list =  	projectManagementPurchaseOrderService.getItemView();
    	
    	
     return 	ResponseHandler.responseBuilder("Item fetched successfully", HttpStatus.OK, list);
    	
    }
    
    @GetMapping("/itemViewPagination")
    public ResponseEntity<Object> getPurchaseOrderViewByPagination(@RequestParam("page") Long page,
    		@RequestParam("rpp") Integer rpp) {

    	List<POItemV03ViewDto> list =  	projectManagementPurchaseOrderService.getPurchaseOrderViewByPagination(page,rpp);
    	
    	
     return 	ResponseHandler.responseBuilder("Item fetched successfully", HttpStatus.OK, list);
    	
    }
    
    

}
