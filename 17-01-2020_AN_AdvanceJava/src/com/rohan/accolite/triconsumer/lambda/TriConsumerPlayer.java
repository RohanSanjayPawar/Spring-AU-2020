package com.rohan.accolite.triconsumer.lambda;

@FunctionalInterface
public interface TriConsumerPlayer<T, U, V> {
	
	public void accept(T t, U u, V v);

}
