package com.rohan.accolite.annotations;

import java.lang.reflect.Method;

public class PlayerAnnotations {
	
	public static void main(String args[])throws Exception{  
		
		Player player = new Player();
		PlayerDefault playerDefault = new PlayerDefault();
		PlayerAnnotate playerAnnotate = new PlayerAnnotate(101);
		
		
		System.out.println("============================================");
		System.out.println("BALLON D'OR RESULTS 2019");
		System.out.println("============================================");
		
		Class<? extends PlayerAnnotate> classType = playerAnnotate.getClass();  
		RohanAnnotation rohanAnnotation = classType.getAnnotation(RohanAnnotation.class);  
		System.out.println("Ballon D'or third place: "+rohanAnnotation.playerName());
		
		
		Method method = player.getClass().getMethod("playerDetails");  
		rohanAnnotation = method.getAnnotation(RohanAnnotation.class);  
		System.out.println("Ballon D'or runner up: "+rohanAnnotation.playerName());
		
		
		method = playerDefault.getClass().getMethod("ballonDorWinner");  
		rohanAnnotation = method.getAnnotation(RohanAnnotation.class);  
		System.out.println("Ballon D'or winner: "+rohanAnnotation.playerName());		
	}
}
