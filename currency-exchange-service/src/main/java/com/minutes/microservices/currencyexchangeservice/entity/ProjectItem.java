package com.minutes.microservices.currencyexchangeservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@Table(name ="item")
public class ProjectItem {

	//# item_id, flag, quantity, unit_cost, itemheaderid DB column


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	 private	Long itemId;
	
	@Column(name = "quantity")
	private Long qty;
	
	@Column(name = "flag")
	private String itemFlag;
	
	@Column(name = "unitCost")
	private long unitCost;
	
	@Column(name = "itemName")
	private String itemName;
	
	@Column(name = "itemDesc")
	private String itemDescription;
	
	@Column(name = "itemNum")
	private String itemNumber;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "itemheaderid")
	private ProjectHeader header;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
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

	public ProjectHeader getHeader() {
		return header;
	}

	public void setHeader(ProjectHeader header) {
		this.header = header;
	}

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

	
}
