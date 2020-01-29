package com.rohan.kafka.KafkaDemo.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohan.kafka.KafkaDemo.services.Producer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	private final Producer producer;

	@Autowired
	public KafkaController(Producer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				Random random = new Random();
				int number = random.nextInt(10000);
				producer.sendMessage(number+"");
			}
		}, 0, 2000);
	}
}