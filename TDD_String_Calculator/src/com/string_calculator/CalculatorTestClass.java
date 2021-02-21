package com.string_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTestClass {

	@Test
	void returnZeroForEmptyString(){
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	void returnNumberForSingleNumber(){
		assertEquals(4, Calculator.add("4"));
	}
	
	@Test
	void returnSumForTwoNumbers(){
		assertEquals(7, Calculator.add("4,3"));
	}
	
	@Test
	void returnSumForUnknownNumbers(){
		assertEquals(2050, Calculator.add("3, 5, 6, 11, 59, 43, 55, 77, 81, 92, 101, 321, 42, 645, 342, 69, 98"));
	}
	
	@Test
	void acceptNewlineBetweenNumbers1(){
		assertEquals(12, Calculator.add("4, 3\n5"));
	}
	
	@Test
	void acceptNewlineBetweenAllNumbers(){
		assertEquals(16, Calculator.add("4\n 3\n9"));
	}
	
	@Test
	void acceptCustomDelimiter(){
		assertEquals(9, Calculator.add("//:\n4:5"));
	}
	
	@Test
	void acceptCustomDelimiterMultiple(){
		assertEquals(25, Calculator.add("//:\n4:5:12:4"));
	}
	
	
	
}
