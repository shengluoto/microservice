package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

    public int lengthOfLongestSubstring4(String s) {
        int longest = 0;
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < length; i ++){

            map.put(s.charAt(i), i);
            longest =0;
        }
        return longest;
    }

    public int lengthOfLongestSubstring5(String s) {
        int longest = 0;
        int length = s.length();
        int left = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < length; i++){
            if (set.add(s.charAt(i))) {
                continue;
            }
            set.remove(s.charAt(i));
            longest = Math.max(longest, i-left);
            --i;
            ++left;
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

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int result = 0;
        int remain = 0;
        while (temp!=0) {
            remain = temp%10;
            temp = temp/10;
            result = result*10 + remain;
        }
        return x == result ? true : false;
    }

    public static int romanToInt(String s) {
        Map<Integer, Integer> combinationMap = new HashMap<>();
        combinationMap.put('I'+'V', 4);
        combinationMap.put('I'+'X', 9);
        combinationMap.put('X'+'L', 40);
        combinationMap.put('X'+'C', 90);
        combinationMap.put('C'+'D', 400);
        combinationMap.put('C'+'M', 900);
        Map<Character, Integer> singleMap = new HashMap<>();
        singleMap.put('I', 1);
        singleMap.put('V', 5);
        singleMap.put('X', 10);
        singleMap.put('L', 50);
        singleMap.put('C', 100);
        singleMap.put('D', 500);
        singleMap.put('M', 1000);
        int length = s.length();
        int start = 0;
        int num = 0;
        int result = 0;
        Integer tempStr = null;
        while (start < length) {
            tempStr = s.charAt(start)+s.charAt(start+1);
            if (combinationMap.containsKey(tempStr)) {
                num = combinationMap.get(tempStr);
                start +=2;
            } else {
                num = singleMap.get(s.charAt(start));
                ++start;
            }
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring.romanToInt("III");
    }
}
