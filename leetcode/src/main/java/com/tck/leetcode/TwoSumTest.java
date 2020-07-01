package com.tck.leetcode;


import java.util.HashMap;
import java.util.Map;

class TwoSumTest {

	public int[] twoSum(int[] nums, int target) {
		int size = nums.length;
		int[] result = {0,0};
		int temp = 0;
		Map<Integer,Integer> tempMap = new HashMap<>(nums.length);
		for (int i=0; i<size; i++) {
			tempMap.put(nums[i],i);
		}
		for (int i=0; i<size; i++) {
			temp = target - nums[i];
			if (null != tempMap.get(temp)) {
				result[0] = i;
				result[1] = tempMap.get(temp);
				break;
			}
		}
		return result;
	}
}
