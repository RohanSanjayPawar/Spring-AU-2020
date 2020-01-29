package com.practice.test;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	@InjectMocks
	MathApplication math = new MathApplication();

	@Mock
	CalculatorService calculatorService;

	@Test
	public void testAdd() {
		// add the behavior of calculator service to add two numbers
		when(calculatorService.add(60.0, 9.0)).thenReturn(69.00);
		when(calculatorService.subtract(70.0, 1.0)).thenReturn(69.0);
		when(calculatorService.multiply(23.0, 3.0)).thenReturn(69.00);
		when(calculatorService.divide(138.0, 2.0)).thenReturn(69.00);
		when(calculatorService.power(3.0, 4.0)).thenReturn(81.00);

		// test the add functionality
		Assert.assertEquals(calculatorService.add(60.0, 9.0), 69.0, 0);
		Assert.assertEquals(calculatorService.subtract(70.0, 1.0), 69.0, 0);
		Assert.assertEquals(calculatorService.multiply(23.0, 3.0), 69.0, 0);
		Assert.assertEquals(calculatorService.divide(138.0, 2.0), 69.0, 0);
		Assert.assertEquals(calculatorService.power(3.0, 4.0), 69.00, 0);

		InOrder inOrder = Mockito.inOrder(calculatorService);

		inOrder.verify(calculatorService).add(60.0, 9.0);
		inOrder.verify(calculatorService).subtract(70.0, 1.0);
		inOrder.verify(calculatorService).multiply(23.0, 3.0);
		inOrder.verify(calculatorService).divide(138.0, 2.0);
		inOrder.verify(calculatorService).power(3.0, 4.0);
	}
}