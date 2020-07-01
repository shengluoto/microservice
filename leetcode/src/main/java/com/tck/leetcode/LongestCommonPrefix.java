package com.tck.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length == 0) {
            return "";
        }
        int minLength = strs[0].length();
        int tempLength = 0;
        for (int i=0; i<length; i++) {
            tempLength = strs[i].length();
            if (tempLength < minLength) {
                minLength = tempLength;
            }
        }
        if (minLength == 0) {
            return "";
        }
        int[] prefixs = new int[minLength];
        String firstStr = strs[0];
        for (int firstStrOfI=0; firstStrOfI<minLength; firstStrOfI++) {
            prefixs[firstStrOfI] = firstStr.charAt(firstStrOfI);
        }
        String tempStr = null;
        for (int i=1; i<length; i++) {
            tempStr = strs[i];
            for (int j=0; j<minLength; j++) {
                if (prefixs[j] != tempStr.charAt(j)) {
                    prefixs[j] = 0;
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder("");
        for (int value : prefixs) {
            if (value == 0) {
                break;
            }
            result.append(Character.toString((char) value));
        }
        return result.toString();
    }

    public static boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        int length = s.length();
        if (length%2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char tempChar = '0';
        char tempPop = '0';
        for(int i=0; i<length; i++) {
            tempChar = s.charAt(i);
            if (map.containsKey(tempChar)) {
                try {
                    tempPop = stack.pop();
                } catch (Exception e) {
                    return false;
                }
                if (map.get(tempChar) != tempPop) {
                    return false;
                }
            } else {
                stack.push(tempChar);
            }
        }
        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

}
