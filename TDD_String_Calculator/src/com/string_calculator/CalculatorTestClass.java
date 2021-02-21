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
	
}
