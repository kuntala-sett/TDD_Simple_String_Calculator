package com.string_calculator;

public class Calculator {

	public static int add(String nums){
		int sum = 0;
		if(nums.isBlank())
			sum = 0;
		else {
			String tokens[];

			if(nums.startsWith("//")) {
				int idx = nums.indexOf("\n");
				String delimit = nums.substring(2,idx);
				delimit = delimit + "|\n";
				String exp = nums.substring(idx+1);
				tokens = exp.split(delimit);
			}
			else {
				tokens = nums.split(",|\n");
			}
			
			for(int i = 0; i<tokens.length; i++) {
				int n = Integer.parseInt(tokens[i].trim());
				sum += n;
			}
		}
		
		return sum;
	}
}
