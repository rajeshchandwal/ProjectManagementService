package com.minutes.microservices.currencyexchangeservice.dto.inter;

public class POItemV03ViewDto {
	
	private Long quantity;
	private Long price;
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

	
}
