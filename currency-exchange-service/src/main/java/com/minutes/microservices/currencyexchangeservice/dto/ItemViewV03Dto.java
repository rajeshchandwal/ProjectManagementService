package com.minutes.microservices.currencyexchangeservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.minutes.microservices.currencyexchangeservice.entity.ProjectItem;
import com.minutes.microservices.currencyexchangeservice.entity.PurchaseOrderHeader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ItemViewV03Dto {

	private	Long itemId;
	
	private	Long poCalculatedCost;
	
	private Long projectName;
	
	private String flag;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getPoCalculatedCost() {
		return poCalculatedCost;
	}

	public void setPoCalculatedCost(Long poCalculatedCost) {
		this.poCalculatedCost = poCalculatedCost;
	}

	public Long getProjectName() {
		return projectName;
	}

	public void setProjectName(Long projectName) {
		this.projectName = projectName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	

}
