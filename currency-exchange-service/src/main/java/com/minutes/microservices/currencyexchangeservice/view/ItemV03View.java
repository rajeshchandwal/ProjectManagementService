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
@Table(name ="pm_item_v03")
public class ItemV03View {

	// # item_id, PO_CALCULATED_COST, project_name, flag

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	 private	Long itemId;
	
	@Column(name = "PO_CALCULATED_COST")
	 private	Long poCalculatedCost;
	
	@Column(name = "project_name")
	private String projectName;
	
	@Column(name = "flag")
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
}
