package com.rohan.accolite.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target({ElementType.METHOD, ElementType.TYPE}) 
public @interface RohanAnnotation {
	String playerName() default "Lionel Messi";
	String club() default "FC Barcelona";
	int goals() default 200;
	int age() default 32;
}

class Player {  
	@RohanAnnotation(playerName="Sadio Mane", club="Liverpool", goals=218, age=26)  
	public void playerDetails(){
		System.out.println("Ballon D'or");  
	}
}

class PlayerDefault {  
	@RohanAnnotation
	public void ballonDorWinner(){
		System.out.println("Ballon D'or Default Annotations");
	}  
} 

@RohanAnnotation(playerName="Cristiano Ronaldo", club="Juventus", goals=702, age=34)
class PlayerAnnotate {
	int playerId;
	
	PlayerAnnotate(int playerId) {
		this.playerId = playerId;
	}
}