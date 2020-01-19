package com.rohan.accolite.triconsumer.lambda;

import com.rohan.accolite.xml.sax.Players;

public class LambdaClass {
	
	// Function to call the TriConsumer
	private <T, U, V> void accept(TriConsumerPlayer<T, U, V> triConsumer, T t, U u, V v) {
		triConsumer.accept(t, u, v);
	}
	
	// Exception handling using lambda wrapper
	// A generic lambda is created for the triConsumer functional interface
	static <T, U, V,  E extends Exception> TriConsumerPlayer<T, U, V> triConsumerWrapper(TriConsumerPlayer<T, U, V> triConsumer, Class<E> exceptionClass) {
		return (t, u, v) -> {
			try {
				triConsumer.accept(t, u, v);
			} catch (Exception e) {
				try {
	                E exception = exceptionClass.cast(e);
	                System.err.println("Exception: " + exception.getMessage());
	                System.out.println();
	            } catch (ClassCastException exc) {
	                throw new RuntimeException(exc);
	            }
			}
		};
	}
	
	public static void main(String args[]) {
		
		LambdaClass lambdaClass = new LambdaClass();
		
		// T, U, V all are Integers
		TriConsumerPlayer<Integer, Integer, Integer> maxGoalsScored = triConsumerWrapper((Integer messi, Integer ronaldo, Integer sadio_mane) -> {
			int maxGoals = (messi > ronaldo) ? ((messi > sadio_mane) ? messi : sadio_mane) : ((ronaldo > sadio_mane) ? ronaldo : sadio_mane);
			
			System.out.println("Maximum goals scored in the callender year of 2019 is: "+maxGoals);
		}, ArithmeticException.class);
		
		lambdaClass.accept(maxGoalsScored, 500, 600, 700);
		
		
		// T, U, V all are Strings
		TriConsumerPlayer<String, String, String> concatString = triConsumerWrapper((String name1, String name2, String name3) -> {
			String combined = name1.concat(" "+name2).concat(" "+name3);
			
			System.out.println("Concated string is: "+combined);
		}, Exception.class);
		
		lambdaClass.accept(concatString, "FC", "Barcelona", "2020");
		
		
		Players player1 = new Players();
		player1.setFirstname("Lionel");
		player1.setClub("FC Barcelona");
		player1.setAge(32);
		player1.setLastname("Messi");
		player1.setNationality("Argentina");
		
		
		Players player2 = new Players();
		player2.setFirstname("Cristiano");
		player2.setClub("Juventus");
		player2.setAge(34);
		player2.setLastname("Ronaldo");
		player2.setNationality("Portugal");
		
		Players player3 = new Players();
		player3.setFirstname("Sadio");
		player3.setClub("Liverpool");
		player3.setAge(26);
		player3.setLastname("Mane");
		player3.setNationality("Senegal");
		
		// A triConsumer lambda function with all the parameters as Player Objects (SAX XML parser object)
		TriConsumerPlayer<Players, Players, Players> ballonDor = triConsumerWrapper((Players t1, Players t2, Players t3) -> {
			// 1000/Players age under 30
			int count = 0;
			
			if(1000/t1.getAge() < 30)
				count++;
			if(1000/t2.getAge() < 30)
				count++;
			if(1000/t3.getAge() < 30)
				count++;
			System.out.println("Number of players under the age of 30 is: "+count);
		}, ArithmeticException.class);
		
		lambdaClass.accept(ballonDor, player1, player2, player3);
		
		// The below example demonstrates the wrapper lambda for exception handling, wherein the object has default zero value for age
		// Players player4 = new Players();
		// lambdaClass.accept(ballonDor, player1, player2, player4);
	}

}
