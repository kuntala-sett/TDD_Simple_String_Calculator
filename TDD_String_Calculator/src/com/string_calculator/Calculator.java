package com.string_calculator;

public class Calculator {

	public static int add(String nums){
		int sum = 0;
		if(nums.isBlank())
			sum = 0;
		else {
			String tokens[];
			String negatives = "";
			boolean flag_negative = false;

			if(nums.startsWith("//")) {
				int idx = nums.indexOf("\n");
				String delimit = nums.substring(2,idx);
				delimit = "\\" + delimit + "|\n";
				String exp = nums.substring(idx+1);
				tokens = exp.split(delimit);
			}
			else {
				tokens = nums.split(",|\n");
			}
			
			for(int i = 0; i<tokens.length; i++) {
				int n = Integer.parseInt(tokens[i].trim());

				if(n<0) {
					negatives += " " + n;
					flag_negative = true;
				}
				
				if(!flag_negative)
					if(n<=1000)
						sum += n;
			}
			
			if(flag_negative) {
				throw new RuntimeException("No Negatives Allowed :" + negatives);
			}
			
		}
		
		return sum;
	}
}
