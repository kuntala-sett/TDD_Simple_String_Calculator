package com.string_calculator;

public class Calculator {

	public static int add(String nums){
		int sum = 0;
		if(nums.isBlank())
			sum = 0;
		else {
			sum += Integer.parseInt(nums);
		}
		
		return sum;
	}
}
