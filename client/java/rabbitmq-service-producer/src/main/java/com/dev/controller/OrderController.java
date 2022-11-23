package com.dev.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.entity.TbOrder;
import com.dev.model.RequestOrder;
import com.dev.services.OrderService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/orders")
	public ResponseEntity<Object> addApiCatalog(@Validated @RequestBody RequestOrder request) throws Exception {
		Map<String, Object> body = new HashMap<String, Object>();
		
		
		TbOrder tbOrder = orderService.createOrder(request);

		body.put("order", tbOrder );
		
		ResponseEntity<Object> resp = new ResponseEntity<Object>(body, HttpStatus.CREATED);
		
		return resp;
	}
}
