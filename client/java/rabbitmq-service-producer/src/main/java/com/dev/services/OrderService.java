package com.dev.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.entity.TbOrder;
import com.dev.model.RequestOrder;
import com.dev.repo.OrderRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	RabbitMQSender rabbitMQSender;
	
	static int orderIndex = 0;
	
	@Transactional(rollbackFor=Exception.class)
	public TbOrder createOrder(RequestOrder req) {
		
		TbOrder tbOrder = new TbOrder();
		
		BeanUtils.copyProperties(req, tbOrder);
		
		orderIndex++;
		tbOrder.setId(Long.parseLong(String.valueOf(orderIndex)));
		tbOrder.setOrderNo(UUID.randomUUID().toString());
		tbOrder.setOrderStatus("INITIAL");
		tbOrder.setCreateBy(req.getUserId());
		
		//tbOrder = orderRepository.save(tbOrder);
		
		System.out.println("tbOrder : " + tbOrder.toString());
		
		rabbitMQSender.send(tbOrder);
		log.info("Message sent to the RabbitMQ Successfully");
		
		return tbOrder;
	}
}
