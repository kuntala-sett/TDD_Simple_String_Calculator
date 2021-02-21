package com.string_calculator;

public class Calculator {

	public static int add(String nums){
		int sum = 0;
		if(nums.isBlank())
			sum = 0;
		else {
			String tokens[];
			tokens = nums.split(",");
			for(int i = 0; i<tokens.length; i++) {
				int n = Integer.parseInt(tokens[i].trim());
				sum += n;
			}
		}
		
		return sum;
	}
}
