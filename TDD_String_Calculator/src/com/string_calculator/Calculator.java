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
					int idxStart = delimit.indexOf("[");
					int idxEnd = delimit.indexOf("]");

					//escaping the delimiter character
					String tempDelimit = "\\";
					//adding just one of the character and then + for multiple occurrence  ---> \*+
					tempDelimit += delimit.charAt(idxStart + 1);
					tempDelimit += "+";
		
					delimit = tempDelimit;
				}

				//to accommodate newline character
				delimit += "|\n";
				//getting actual expression from after the first occurrence of newline character
				String numbersExpression = nums.substring(idx + 1);
				tokens = numbersExpression.split(delimit);

				
//			    System.out.println(tokens[0]);
//				System.out.println(tokens[2]);
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
