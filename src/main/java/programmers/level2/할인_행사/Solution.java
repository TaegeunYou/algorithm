package main.java.programmers.level2.할인_행사;

import java.util.HashMap;

/**
 * ["banana", "apple", "rice", "pork", "pot"]
 * [3, 2, 2, 2, 1]
 * ["chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"]
 */
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        for (int rt = 0; rt < discount.length + 8; rt++) {
            if (rt < discount.length) {
                String rts = discount[rt];
                if (map.get(rts) != null) {
                    map.put(rts, map.get(rts) - 1);
                }
            }
            int lt = rt - 10;
            if (lt >= 0) {
                String lts = discount[lt];
                if (map.get(lts) != null) {
                    map.put(lts, map.get(lts) + 1);
                }
            }
            if (avail()) {
                answer++;
            }
        }
        return answer;
    }

    boolean avail() {
        boolean flag = true;
        for (String s : map.keySet()) {
            if (map.get(s) > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}