package com.minutes.microservices.currencyexchangeservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name ="purchaseOrderBOM")
public class PurchaseOrderBOM {
	//# project_header_id, customer, manager, status DB column

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_BOM_id")
	 private	Long bomId;
	
	
	@Lob
	@Column(name = "POBOMPDF", columnDefinition = "BLOB" )
	private byte[] bomPdf;
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poHeaderBOMId")
	private PurchaseOrderHeader projectPurchaseOrderHeader;





	public Long getBomId() {
		return bomId;
	}


	public void setBomId(Long bomId) {
		this.bomId = bomId;
	}


	public byte[] getBomPdf() {
		return bomPdf;
	}


	public void setBomPdf(byte[] bomPdf) {
		this.bomPdf = bomPdf;
	}


	public PurchaseOrderHeader getProjectPurchaseOrderHeader() {
		return projectPurchaseOrderHeader;
	}


	public void setProjectPurchaseOrderHeader(PurchaseOrderHeader projectPurchaseOrderHeader) {
		this.projectPurchaseOrderHeader = projectPurchaseOrderHeader;
	}
	
	
	
}
