package com.minutes.microservices.currencyexchangeservice.view;

import javax.persistence.Basic;
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
@Table(name ="pm_purchase_order_item_v03")
public class PurchaseOrderItemV03 {

//	# item_id, quantity, unit_price, purchase_number, item_name, item_num, item_desc, flag
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	 private	Long itemId;
	
	@Column(name = "quantity")
	 private	Long qty;
	
	@Column(name = "unit_price")
	private Long unitPrice;
	
	@Column(name = "purchase_number")
	private String purchaseOrderNumber;
	

	
	@Column(name = "item_num")
	private String itemNumber;
	
	@Column(name = "item_desc")
	private String itemDescription;
	
	@Column(name = "flag")
	private String flag;

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

	public Long getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}



	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
}
