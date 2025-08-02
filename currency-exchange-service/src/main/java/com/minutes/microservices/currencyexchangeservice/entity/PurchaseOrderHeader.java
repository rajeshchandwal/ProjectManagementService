package com.minutes.microservices.currencyexchangeservice.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.BatchSize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Transactional
@Table(name ="purchaseOrderHeader")
public class PurchaseOrderHeader  {
	//# project_header_id, customer, manager, status DB column

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_header_id")
	 private Long purchaseOrderHeaderId;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;

	@Column(name = "purchase_number")
	private String purchaseOrderNumber;
	
	@Column(name = "vendorNumber")
	private String vendorNumber; 
	
	@Column(name = "vendorName")
	private String vendorName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poprojectId")
	private ProjectHeader header;
	
	@OneToMany(mappedBy = "projectPurchaseOrderHeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@BatchSize(size = 5)
	private List<PurchaseOrderDetail> purchaseOrderDetail;
	
	@OneToOne(mappedBy = "projectPurchaseOrderHeader", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private PurchaseOrderBOM purchaseOrderBOM;
	
	
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

	public ProjectHeader getHeader() {
		return header;
	}

	public void setHeader(ProjectHeader header) {
		this.header = header;
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

	public List<PurchaseOrderDetail> getPurchaseOrderDetail() {
		return purchaseOrderDetail;
	}

	public void setPurchaseOrderDetail(List<PurchaseOrderDetail> purchaseOrderDetail) {
		this.purchaseOrderDetail = purchaseOrderDetail;
	}

	public PurchaseOrderBOM getPurchaseOrderBOM() {
		return purchaseOrderBOM;
	}

	public void setPurchaseOrderBOM(PurchaseOrderBOM purchaseOrderBOM) {
		this.purchaseOrderBOM = purchaseOrderBOM;
	}
	
	
	
}
