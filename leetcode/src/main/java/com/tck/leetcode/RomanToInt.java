package com.tck.leetcode;

import java.util.*;

public class RomanToInt {
    static Map<String, Integer> combinationMap;
    {
        combinationMap = new HashMap<>();
        combinationMap.put("IV", 4);
        combinationMap.put("IX", 9);
        combinationMap.put("XL", 40);
        combinationMap.put("XC", 90);
        combinationMap.put("CD", 400);
        combinationMap.put("CM", 900);
    }

    static Map<String, Integer> singleMap;
    {
        singleMap = new HashMap<>();
        singleMap.put("I", 1);
        singleMap.put("V", 5);
        singleMap.put("X", 10);
        singleMap.put("L", 50);
        singleMap.put("C", 100);
        singleMap.put("D", 500);
        singleMap.put("M", 1000);
    }

    static Map<Character, Integer> singleCharMap;
    {
        singleCharMap = new HashMap<>();
        singleCharMap.put('I', 1);
        singleCharMap.put('V', 5);
        singleCharMap.put('X', 10);
        singleCharMap.put('L', 50);
        singleCharMap.put('C', 100);
        singleCharMap.put('D', 500);
        singleCharMap.put('M', 1000);
    }

    public static int romanToInt(String s) {
        for (Map.Entry<String, Integer> entry : combinationMap.entrySet()) {
            s = s.replaceAll(entry.getKey(), entry.getValue()+" ");
        }
        for (Map.Entry<String, Integer> entry : singleMap.entrySet()) {
            s = s.replaceAll(entry.getKey(), entry.getValue()+" ");
        }
        String[] array = s.split(" ");
        int result = 0;
        for (String s1 : array) {
            result += Integer.parseInt(s1);
        }
        return result;
    }

    public static int romanToInt2(String s) {
        int result = 0;
        int length = s.length();
        int temp = 0;
        String tempStrOne = null;
        String tempStrTwo = null;
        for (int i=0; i< length;) {
            tempStrOne = s.substring(i, i+1);
            if (i+1 < length) {
                tempStrTwo = s.substring(i, i+2);
                if (combinationMap.containsKey(tempStrTwo)) {
                    temp = combinationMap.get(tempStrTwo);
                    i += 2;
                } else {
                    temp = singleMap.get(tempStrOne);
                    ++i;
                }
            } else {
                temp = singleMap.get(tempStrOne);
                ++i;
            }
            result += temp;
        }
        return result;
    }

    public static int romanToInt3(String s) {
        int result = 0;
        int pre = singleCharMap.get(s.charAt(0));
        int next = 0;
        int length = s.length();
        for (int i=1; i< length; i++) {
            next = singleCharMap.get(s.charAt(i));
            if (pre < next) {
                result -= pre;
            } else {
                result += pre;
            }
            pre = next;
        }
        return result;
    }
}
