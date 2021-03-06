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
	void acceptCustomDelimiterMultipleTimes(){
		assertEquals(25, Calculator.add("//:\n4:5:12:4"));
	}
	
	@Test
	void acceptCustomDelimiterMultipleTimes2(){
		assertEquals(25, Calculator.add("//*\n4*5\n12*4"));
	}
	
	@Test
	void acceptNewlineWithCustomDelimiter(){
		assertEquals(23, Calculator.add("//:\n4:5\n5\n2:7"));
	}
	
	@Test
	void rejectSumOfNegatives(){
			try {
				Calculator.add("4,-2");
				fail("ExceptionExpected");
			}
			catch (RuntimeException e) {
				assertEquals("No Negatives Allowed : -2", e.getMessage());
			}
	}
	
	@Test
	void ignoreGreaterThanThousand(){
		assertEquals(30, Calculator.add("//:\n4:1005:26"));
	}
	
	@Test
	void acceptMultipleLengthCustomDelimiter(){
		assertEquals(25, Calculator.add("//[***]\n4***5***12***4"));
	}
	
	@Test
	void acceptMultipleCustomDelimiters(){
		assertEquals(25, Calculator.add("//[*][%][:]\n4%5:12*4"));
	}
	
	@Test
	void acceptMultipleCustomDelimiters1(){
		assertEquals(32, Calculator.add("//[*][%][:][.][&]\n3*4.2%5:12*4&2"));
	}
	
	@Test
	void acceptMultipleCustomDelimiters2(){
		assertEquals(30, Calculator.add("//[*][%][.]\n4.5%12*4\n5"));
	}

	
}
