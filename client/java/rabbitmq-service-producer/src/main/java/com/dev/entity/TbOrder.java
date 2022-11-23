package com.dev.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class TbOrder implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "orderNo")
	private String orderNo;

	@Column(name = "orderDate")
	@CreationTimestamp
	private Date orderDate;

	@Column(name = "createBy")
	private String createBy;

	private String orderStatus;

	@Column(name = "productName")
	private String productName;
	
	@Column(name = "price")
	private Double price;
	@Column(name = "qty")
	private Integer qty;
	
	@Column(name = "customersId")
	private String customersId;
	@Column(name = "customerName")
	private String customerName;
	@Column(name = "customerAddress")
	private String customerAddress;
	@Column(name = "customerEmail")
	private String customerEmail;
	@Column(name = "customerMobileNo")
	private String customerMobileNo;
	@Column(name = "paymentMethod")
	private String paymentMethod;
	@Column(name = "bankAccountNo")
	private String bankAccountNo;
	@Column(name = "bankAccountName")
	private String bankAccountName;
	@Column(name = "currency")
	private String currency;
	@Column(name = "shippingModule")
	private String shippingModule;

}
