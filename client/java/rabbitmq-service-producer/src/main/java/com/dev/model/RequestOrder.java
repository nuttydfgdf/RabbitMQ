package com.dev.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userId", "productName", "price", "qty", "customersId", "customerName", "customerAddress",
		"customerEmail", "customerMobileNo", "paymentMethod", "bankAccountNo", "bankAccountName", "currency",
		"shippingModule" })
@Generated("jsonschema2pojo")
@Data
public class RequestOrder {

	@JsonProperty("userId")
	private String userId;
	@JsonProperty("productName")
	private String productName;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("qty")
	private Integer qty;
	@JsonProperty("customersId")
	private String customersId;
	@JsonProperty("customerName")
	private String customerName;
	@JsonProperty("customerAddress")
	private String customerAddress;
	@JsonProperty("customerEmail")
	private String customerEmail;
	@JsonProperty("customerMobileNo")
	private String customerMobileNo;
	@JsonProperty("paymentMethod")
	private String paymentMethod;
	@JsonProperty("bankAccountNo")
	private String bankAccountNo;
	@JsonProperty("bankAccountName")
	private String bankAccountName;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("shippingModule")
	private String shippingModule;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("productName")
	public String getProductName() {
		return productName;
	}

	@JsonProperty("productName")
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@JsonProperty("price")
	public Double getPrice() {
		return price;
	}

	@JsonProperty("price")
	public void setPrice(Double price) {
		this.price = price;
	}

	@JsonProperty("qty")
	public Integer getQty() {
		return qty;
	}

	@JsonProperty("qty")
	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@JsonProperty("customersId")
	public String getCustomersId() {
		return customersId;
	}

	@JsonProperty("customersId")
	public void setCustomersId(String customersId) {
		this.customersId = customersId;
	}

	@JsonProperty("customerName")
	public String getCustomerName() {
		return customerName;
	}

	@JsonProperty("customerName")
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@JsonProperty("customerAddress")
	public String getCustomerAddress() {
		return customerAddress;
	}

	@JsonProperty("customerAddress")
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@JsonProperty("customerEmail")
	public String getCustomerEmail() {
		return customerEmail;
	}

	@JsonProperty("customerEmail")
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@JsonProperty("customerMobileNo")
	public String getCustomerMobileNo() {
		return customerMobileNo;
	}

	@JsonProperty("customerMobileNo")
	public void setCustomerMobileNo(String customerMobileNo) {
		this.customerMobileNo = customerMobileNo;
	}

	@JsonProperty("paymentMethod")
	public String getPaymentMethod() {
		return paymentMethod;
	}

	@JsonProperty("paymentMethod")
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@JsonProperty("bankAccountNo")
	public String getBankAccountNo() {
		return bankAccountNo;
	}

	@JsonProperty("bankAccountNo")
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	@JsonProperty("bankAccountName")
	public String getBankAccountName() {
		return bankAccountName;
	}

	@JsonProperty("bankAccountName")
	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("shippingModule")
	public String getShippingModule() {
		return shippingModule;
	}

	@JsonProperty("shippingModule")
	public void setShippingModule(String shippingModule) {
		this.shippingModule = shippingModule;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
