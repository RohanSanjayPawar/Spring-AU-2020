package com.rohan.kafka.KafkaDemo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "simple1", groupId = "group_id")
	public void consume(String message) {;
		logger.info(String.format("Message received from Mediator: "+ message));
	}
}
