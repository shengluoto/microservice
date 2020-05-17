package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int longest = s.length();
        int length = s.length();
        int temp = 0;
        Set<Character> repeat = null;
        boolean isSuccess = true;
        int start = 0;
        while (start < length) {
            temp = start+longest;
            // 从start截取长度为longest
            repeat = new HashSet<>(longest);
            isSuccess = true;
            for(int i=start; i<temp; i++) {
                if (!repeat.add(s.charAt(i))) {
                    isSuccess = false;
                    continue;
                }
            }
            if (isSuccess) {
                return longest;
            }
            start++;
        }
        return longest;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring3(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}
