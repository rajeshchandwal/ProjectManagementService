package com.minutes.microservices.currencyexchangeservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProjectItemDto {
	//# projectHeaderId, customer, manager, status DB column

	
	@NotNull
	 private Long headerId;
	
	
	private Long qty;
	
	@Length(max = 2)
	private String itemFlag;
	
	@Length(max = 2)
	private long unitCost;
	
	
	@Length(max = 2)
	private String itemName;
	
	@Length(max = 2)
	private String itemDescription;
	
	@Length(max = 2)
	private String itemNumber;

	
	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getItemDescription() {
		return itemDescription;
	}


	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}


	public String getItemNumber() {
		return itemNumber;
	}


	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}


	public Long getHeaderId() {
		return headerId;
	}


	public void setHeaderId(Long headerId) {
		this.headerId = headerId;
	}


	public Long getQty() {
		return qty;
	}


	public void setQty(Long qty) {
		this.qty = qty;
	}


	public String getItemFlag() {
		return itemFlag;
	}


	public void setItemFlag(String itemFlag) {
		this.itemFlag = itemFlag;
	}


	public long getUnitCost() {
		return unitCost;
	}


	public void setUnitCost(long unitCost) {
		this.unitCost = unitCost;
	}

}
