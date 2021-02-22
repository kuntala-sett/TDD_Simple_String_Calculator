package com.string_calculator;

public class Calculator {

	public static int add(String nums) {
		int sum = 0;
		if (nums.isBlank())
			sum = 0;
		else {
			String tokens[];
			String negatives = "";
			boolean flag_negative = false;

			if (nums.startsWith("//")) {
				int idx = nums.indexOf("\n");
				String delimit = nums.substring(2, idx);
				//for custom delimiter
				delimit = "\\" + delimit;

				if (delimit.contains("[")) {
					int count = (int) delimit.chars().filter(ch -> ch == '[').count();
					int idxStart = delimit.indexOf("[");
					String tempDelimit = "";
					
					if(count>1) {	//multiple types of delimiter
						tempDelimit += "[";
						
						while(count > 0) {
							tempDelimit += delimit.charAt(idxStart+1);
							idxStart = delimit.indexOf("[", idxStart+1);
							count--;
						}
						
						tempDelimit += "]";
					}
					else {	//only one type of delimiter
						
						//escaping the delimiter character
						tempDelimit = "\\";
						//adding just one of the character of the multiple occurrence of same delimiter
						tempDelimit += delimit.charAt(idxStart + 1);
						
					}
					//  Adding + for multiple occurrences
					tempDelimit += "+";
					delimit = tempDelimit;
				}

				//to accommodate newline character
				delimit += "|\n";
				//getting actual expression from after the first occurrence of newline character
				String numbersExpression = nums.substring(idx + 1);
				tokens = numbersExpression.split(delimit);

			} else {
				tokens = nums.split(",|\n");
			}

			for (int i = 0; i < tokens.length; i++) {
				int n = Integer.parseInt(tokens[i].trim());

				if (n < 0) {
					negatives += " " + n;
					flag_negative = true;
				}

				if (!flag_negative)
					if (n <= 1000)
						sum += n;
			}

			if (flag_negative) {
				throw new RuntimeException("No Negatives Allowed :" + negatives);
			}

		}

		return sum;
	}
}
