package com.accolite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.accolite.model.Point;

@Service
@PropertySource("classpath:application.properties")
public class PointService {
	
	@Autowired
	private Environment env;
	
	public void printPoint() {
		Point point = new Point(Integer.parseInt(env.getProperty("point.x")), Integer.parseInt(env.getProperty("point.y")));
 		System.out.println(point);
	}
}
