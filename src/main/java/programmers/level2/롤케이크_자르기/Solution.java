package main.java.programmers.level2.롤케이크_자르기;

import java.util.HashMap;

/**
 * [1, 2, 1, 3, 1, 4, 1, 2]
 */
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int t : topping) {
            map1.put(t, map1.getOrDefault(t, 0) + 1);
        }
        for (int t : topping) {
            if (map1.get(t) - 1 == 0) {
                map1.remove(t);
            } else {
                map1.put(t, map1.get(t) - 1);
            }
            map2.put(t, map2.getOrDefault(t, 0) + 1);
            if (map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}