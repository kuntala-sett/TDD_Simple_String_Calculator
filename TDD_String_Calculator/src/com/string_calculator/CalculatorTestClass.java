package com.string_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Calculator.Calculator;

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
		assertEquals(7, Calculator.add("4, 3"));
	}
	
}
