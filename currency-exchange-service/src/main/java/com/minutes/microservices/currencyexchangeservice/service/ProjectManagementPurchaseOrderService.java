package com.minutes.microservices.currencyexchangeservice.service;



import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.SerializationUtils;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.minutes.microservices.currencyexchangeservice.dto.ProjectHeaderDto;
import com.minutes.microservices.currencyexchangeservice.dto.PurchaseOrderDetailDto;
import com.minutes.microservices.currencyexchangeservice.dto.PurchaseOrderHeaderDto;
import com.minutes.microservices.currencyexchangeservice.dto.PurchaseOrderItemViewV03Dto;
import com.minutes.microservices.currencyexchangeservice.dto.inter.POItemV03View;
import com.minutes.microservices.currencyexchangeservice.dto.inter.POItemV03ViewDto;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectHeader;
import com.minutes.microservices.currencyexchangeservice.entity.ProjectItem;
import com.minutes.microservices.currencyexchangeservice.entity.PurchaseOrderBOM;
import com.minutes.microservices.currencyexchangeservice.entity.PurchaseOrderDetail;
import com.minutes.microservices.currencyexchangeservice.entity.PurchaseOrderHeader;
import com.minutes.microservices.currencyexchangeservice.repository.ItemV03ViewRepository;
import com.minutes.microservices.currencyexchangeservice.repository.ProjectManagementHeaderRepository;
import com.minutes.microservices.currencyexchangeservice.repository.ProjectManagementItemRepository;
import com.minutes.microservices.currencyexchangeservice.repository.ProjectManagementPODetailRepository;
import com.minutes.microservices.currencyexchangeservice.repository.ProjectManagementPOHeaderRepository;
import com.minutes.microservices.currencyexchangeservice.repository.PurchaseOrderBomRepository;
import com.minutes.microservices.currencyexchangeservice.repository.PurchaseOrderItemV03Repository;
import com.minutes.microservices.currencyexchangeservice.view.ItemV03View;
import com.minutes.microservices.currencyexchangeservice.view.PurchaseOrderItemV03;

@Service
public class ProjectManagementPurchaseOrderService {
	
	

private ProjectManagementPOHeaderRepository projectManagementPOHeaderRepository;

private ProjectManagementPODetailRepository projectManagementPODetailRepository;

private ProjectManagementItemRepository projectManagementItemRepository;

private ProjectManagementHeaderRepository projectManagementHeaderRepository;

private PurchaseOrderItemV03Repository purchaseOrderItemV03Repository;

private ItemV03ViewRepository itemV03ViewRepository;

private PurchaseOrderBomRepository purchaseOrderBomRepository;


public ProjectManagementPurchaseOrderService(ProjectManagementPOHeaderRepository projectManagementPOHeaderRepository,
		ProjectManagementPODetailRepository projectManagementPODetailRepository,
		ProjectManagementItemRepository projectManagementItemRepository,
		ProjectManagementHeaderRepository projectManagementHeaderRepository,
		PurchaseOrderItemV03Repository purchaseOrderItemV03Repository, ItemV03ViewRepository itemV03ViewRepository,
		PurchaseOrderBomRepository purchaseOrderBomRepository) {
	super();
	this.projectManagementPOHeaderRepository = projectManagementPOHeaderRepository;
	this.projectManagementPODetailRepository = projectManagementPODetailRepository;
	this.projectManagementItemRepository = projectManagementItemRepository;
	this.projectManagementHeaderRepository = projectManagementHeaderRepository;
	this.purchaseOrderItemV03Repository = purchaseOrderItemV03Repository;
	this.itemV03ViewRepository = itemV03ViewRepository;
	this.purchaseOrderBomRepository = purchaseOrderBomRepository;
}

public void createPurchaseOrder(List<PurchaseOrderHeaderDto> purchaseOrderHeaderDtos,Long projectId) throws IOException {
	
	
 Optional<ProjectHeader> optionalHeader = 	projectManagementHeaderRepository.findById(projectId);
 
 if(optionalHeader.isPresent()) {
	 ProjectHeader header = optionalHeader.get();
	  
	 List<PurchaseOrderHeader> purchaseOrderHeaderList = new ArrayList<>();
	  purchaseOrderHeaderDtos.stream().forEach(purchaseOrderHeaderDto -> {
			 PurchaseOrderHeader poHeader = new PurchaseOrderHeader();
			 
			 BeanUtils.copyProperties(purchaseOrderHeaderDto, poHeader);
			 poHeader.setHeader(header);
			 
			 List<PurchaseOrderDetail> purchaseOrderDetailList = new ArrayList<>();
			 purchaseOrderHeaderDto.getPurchaseOrderDetails().stream().forEach(poDetailDto -> {
				 PurchaseOrderDetail poDetail = new PurchaseOrderDetail();
				 BeanUtils.copyProperties(poDetailDto, poDetail);
				 System.out.println(poDetail.getUnitPrice());
				 ProjectItem item = new ProjectItem();
				Optional<ProjectItem> optionalItem = projectManagementItemRepository.findById(poDetailDto.getProjectItemId());
				if(optionalItem.isPresent()) {
					item = optionalItem.get();
				}
				poDetail.setPoDetailItemId(item);
				poDetail.setProjectPurchaseOrderHeader(poHeader);
				purchaseOrderDetailList.add(poDetail);
			 });
			
			 poHeader.setPurchaseOrderDetail(purchaseOrderDetailList);
			 purchaseOrderHeaderList.add(poHeader); 
		 });
	  projectManagementPOHeaderRepository.saveAll(purchaseOrderHeaderList);
	 // pmBombSave(purchaseOrderHeaderList);
	
 }
 
}

  public List<ItemV03View> getItemView() {
	return	itemV03ViewRepository.findAll();
	}

	public List<PurchaseOrderItemV03> getPurchaseOrderView() {
	return	purchaseOrderItemV03Repository.findAll();
	}
	
	public List<POItemV03ViewDto> getPurchaseOrderViewByPagination(Long page, Integer rpp) {
		
		Pageable paging;
		if(page == 0 || rpp == 0) {
			paging = Pageable.unpaged();
		}
		else {
			paging = PageRequest.of(Math.toIntExact(page > 0 ?page - 1 : 0), rpp);
		}
		List<POItemV03View> listView = 	purchaseOrderItemV03Repository.getViewData(paging);
		
		List<POItemV03ViewDto> poItemViewList  =  listView.stream().map(this::getpoItemV03ViewDto).toList();
		
		return poItemViewList;
		
		
//		List<POItemV03ViewDto> poItemViewList  = listView.stream().map(poItemView -> {
//			POItemV03ViewDto viewDto = new POItemV03ViewDto();
//			BeanUtils.copyProperties(poItemView, viewDto);
//			return viewDto;
//		}).toList();
//		return poItemViewList;	
		
	}
	
	private POItemV03ViewDto getpoItemV03ViewDto(POItemV03View view) {
		POItemV03ViewDto viewDto = new POItemV03ViewDto();
		BeanUtils.copyProperties(view, viewDto);
		return viewDto;
	}

	public void pmBombSave( List<PurchaseOrderHeader> purchaseOrderHeaderList) throws IOException {
		  
//		  ByteArrayOutputStream bos = new ByteArrayOutputStream();
//	    ObjectOutputStream oos = new ObjectOutputStream(bos);
//		    oos.writeObject(purchaseOrderHeaderList);
//		    byte[] bytes = bos.toByteArray();
	////	  
	////	  
//	     ObjectMapper mapper = new ObjectMapper();
//        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//        String jsonString = mapper.writeValueAsString(purchaseOrderHeaderList);
	//////         
	//////         Gson gson = new Gson();
	//////        byte[] data = gson.fromJson(jsonString, byte[].class);
	////	    
	//////	    final ObjectMapper objectMapper = new ObjectMapper();
	//////	    objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	//////	    objectMapper.disable(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS);
	//////	    objectMapper.disable(SerializationFeature.FLUSH_AFTER_WRITE_VALUE);
	//////
	//////	    
	////////	    final byte[] jsoned =  objectMapper.reader().forType( byte[].class).readValue( (DataInput) purchaseOrderHeaderList.get(0));
	//////    final byte[] jsoned = objectMapper.readValue(objectMapper.writeValueAsString(purchaseOrderHeaderList.get(0)), byte[].class);
	////
		 
		 // byte[] data = SerializationUtils.serialize(purchaseOrderHeaderList);
		  
		    ObjectMapper objectMapper = new ObjectMapper();
//		  //  String arrayToJson = objectMapper.writeValueAsString(purchaseOrderHeaderList);
//		    objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//            String jsonString = objectMapper.writeValueAsString(purchaseOrderHeaderList.get(0));
		    PurchaseOrderDetailDto dto = new PurchaseOrderDetailDto();
		    dto.setProjectItemId(1L);
		 
		    String jsonString = objectMapper.writeValueAsString(dto);
		    System.out.println("jsonStrin "+jsonString);
		   // PurchaseOrderDetailDto dto2 = objectMapper.readValue(new File("src/test/resources/json_car.json"), PurchaseOrderDetailDto.class);
		  //objectMapper.writeValue(new File("/currency-exchange-service/src/main/resources/bom.json"), dto);
		    //FileOutputStream fout = new FileOutputStream(new File("/currency-exchange-service/src/main/resources/bom.json"));
		    //objectMapper.writeValue(fout, dto);
//		  PurchaseOrderBOM bom = new PurchaseOrderBOM() ;
//		  PurchaseOrderHeader poHeader  = new PurchaseOrderHeader();
//		  poHeader.setPurchaseOrderHeaderId(1L);
//		  bom.setProjectPurchaseOrderHeader(poHeader);
//		  bom.setBomPdf(data);
//		  
		 // purchaseOrderBomRepository.save(bom); 
		//JsonNode
		  
	  }
}
