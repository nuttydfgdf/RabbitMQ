package com.dev.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dev.entity.TbOrder;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${app.rabbitmq.exchange}")
	private String exchange;

	@Value("${app.rabbitmq.routingkey}")
	private String routingkey;

	public void send(TbOrder order) {
		rabbitTemplate.convertAndSend(exchange, routingkey, order);
		System.out.println("Send msg = " + order);

	}
}