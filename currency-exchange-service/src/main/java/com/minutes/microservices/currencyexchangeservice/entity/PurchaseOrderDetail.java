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
@Table(name ="purchaseOrderDetail")
public class PurchaseOrderDetail {
	//# project_header_id, customer, manager, status DB column

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_detail_id")
	 private	Long purchaseOrderDetailId;
	
	@Column(name = "quantity")
	private Long qty;
	
	@Column(name = "unitPrice")
	private Long unitPrice;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poHeaderDetailId")
	private PurchaseOrderHeader projectPurchaseOrderHeader;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poDetailItemId")
	private ProjectItem poDetailItemId;

	public Long getPurchaseOrderDetailId() {
		return purchaseOrderDetailId;
	}

	public void setPurchaseOrderDetailId(Long purchaseOrderDetailId) {
		this.purchaseOrderDetailId = purchaseOrderDetailId;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}


	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public PurchaseOrderHeader getProjectPurchaseOrderHeader() {
		return projectPurchaseOrderHeader;
	}

	public void setProjectPurchaseOrderHeader(PurchaseOrderHeader projectPurchaseOrderHeader) {
		this.projectPurchaseOrderHeader = projectPurchaseOrderHeader;
	}

	public ProjectItem getPoDetailItemId() {
		return poDetailItemId;
	}

	public void setPoDetailItemId(ProjectItem poDetailItemId) {
		this.poDetailItemId = poDetailItemId;
	}
	
	
	
}
