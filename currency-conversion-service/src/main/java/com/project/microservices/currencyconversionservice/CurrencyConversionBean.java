package com.project.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalConvertedAmount;
	private int port;
	
	public CurrencyConversionBean() {}
	
	
	public CurrencyConversionBean(long id, String from, String to, BigDecimal conversionMultiply, BigDecimal quantity,
			BigDecimal totalConvertedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiply;
		this.quantity = quantity;
		this.totalConvertedAmount = totalConvertedAmount;
		this.port = port;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalConvertedAmount() {
		return totalConvertedAmount;
	}
	public void setTotalConvertedAmount(BigDecimal totalConvertedAmount) {
		this.totalConvertedAmount = totalConvertedAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
	
}
