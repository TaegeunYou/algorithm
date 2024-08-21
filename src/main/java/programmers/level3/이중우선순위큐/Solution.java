package main.java.programmers.level3.이중우선순위큐;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String str : operations) {
            if (str.equals("D 1")) {
                if (map.isEmpty()) continue;
                Map.Entry<Integer, Integer> entry = map.lastEntry();
                if (entry.getValue() == 1) map.pollLastEntry();
                else if (entry.getValue() > 1) map.put(entry.getKey(), entry.getValue() - 1);
            } else if (str.equals("D -1")) {
                if (map.isEmpty()) continue;
                Map.Entry<Integer, Integer> entry = map.firstEntry();
                if (entry.getValue() == 1) map.pollFirstEntry();
                else if (entry.getValue() > 1) map.put(entry.getKey(), entry.getValue() - 1);
            } else {
                int num = Integer.parseInt(str.split(" ")[1]);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        if (map.isEmpty()) return new int[]{0, 0};
        else return new int[]{map.lastEntry().getKey(), map.firstEntry().getKey()};
    }
}