package com.minutes.microservices.currencyexchangeservice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PurchaseOrderHeaderDto {

	 private Long purchaseOrderHeaderId;
	private String address;

	private String phoneNumber;

	private String email;

	private String purchaseOrderNumber;
	
	private String vendorNumber; 
	
	private String vendorName;
	
	private List<PurchaseOrderDetailDto> purchaseOrderDetails;

	public Long getPurchaseOrderHeaderId() {
		return purchaseOrderHeaderId;
	}

	public void setPurchaseOrderHeaderId(Long purchaseOrderHeaderId) {
		this.purchaseOrderHeaderId = purchaseOrderHeaderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}


	public String getVendorNumber() {
		return vendorNumber;
	}

	public void setVendorNumber(String vendorNumber) {
		this.vendorNumber = vendorNumber;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public List<PurchaseOrderDetailDto> getPurchaseOrderDetails() {
		return purchaseOrderDetails;
	}

	public void setPurchaseOrderDetails(List<PurchaseOrderDetailDto> purchaseOrderDetails) {
		this.purchaseOrderDetails = purchaseOrderDetails;
	}

	
}
