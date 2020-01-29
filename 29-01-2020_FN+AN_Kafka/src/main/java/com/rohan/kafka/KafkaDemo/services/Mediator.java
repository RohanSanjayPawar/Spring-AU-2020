package com.rohan.kafka.KafkaDemo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Mediator {
	private final Logger logger = LoggerFactory.getLogger(Mediator.class);
	
	private String message;
	private static final String TOPIC = "simple1";
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage() {
		logger.info(String.format("Message at Mediator: "+ this.message));
		this.kafkaTemplate.send(TOPIC, this.message);
	}
	
	@KafkaListener(topics = "simple2", groupId = "group_id")
	public void consumeMediator(String message) {
		int number = Integer.parseInt(message);
		if(number % 2 != 0) {
			int length = String.valueOf(message).length();
			this.message = length + "";
		} else {
			this.message = number + "";
		}
		logger.info(String.format(this.message));
		this.sendMessage();
	}
}
