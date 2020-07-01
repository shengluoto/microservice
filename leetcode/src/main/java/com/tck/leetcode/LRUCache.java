package com.tck.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by TCK on 2020/5/27.
 */
class LRUCache {
    Map<Integer, Integer> map;
    int totalSize;
    LinkedList<Integer> list;

    public LRUCache(int capacity) {
        list = new LinkedList<>();
        map = new HashMap<>(capacity);
        totalSize = capacity;
    }

    public int get(int key) {
        Integer value = map.get(key);
        if (null == value) {
            return -1;
        } else {
            list.remove(Integer.valueOf(key));
            list.addFirst(key);
            return value;
        }
    }

    public void put(int key, int value) {
        // 删除最近最不经常使用的值
        if (map.containsKey(key)) {
            list.remove(Integer.valueOf(key));
        } else if(totalSize == map.size()) {
            map.remove(list.getLast());
            list.removeLast();
        }
        list.addFirst(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.get(2);
        cache.put(2,6);
        cache.get(1);
        cache.put(1,5);
        cache.put(1,2);
        cache.get(1);
        cache.get(2);
    }
}