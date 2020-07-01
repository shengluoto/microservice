package com.tck.leetcode;


import java.util.HashMap;
import java.util.Map;

class Reverse {

	public int reverse(int x) {
		String[] xArray = Integer.toString(x).split("");
		int length = xArray.length;
		StringBuilder resultStr = new StringBuilder(length);
		int start = 0;
		if (xArray[0].equals("-")) {
			start = 1;
			resultStr.append("-");
		}
		for (int i = length-1; i >= start; i--) {
			resultStr.append(xArray[i]);
		}
		int result = 0;
		try {
			result = Integer.parseInt(resultStr.toString());
		} catch (NumberFormatException e) {
		}
		return result;
	}

	public int reverse2(int x) {
		int result = 0;
		int remainder = 0;
		while(x != 0) {
			remainder = x%10;
			if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && remainder > 7)) {
				return 0;
			}
			if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && remainder < -8)) {
				return 0;
			}
			result = result*10+remainder;
			x = x/10;
		}
		return result;
	}
}
