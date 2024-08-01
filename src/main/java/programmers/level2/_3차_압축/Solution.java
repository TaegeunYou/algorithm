package main.java.programmers.level2._3차_압축;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= 'Z' - 'A'; i++) {
            map.put("" + (char) ('A' + i), i + 1);
        }
        ArrayList<Integer> answer = new ArrayList<>();
        while (!msg.isEmpty()) {
            for (int i = msg.length() - 1; i >= 0; i--) {
                String w = msg.substring(0, i + 1);
                if (map.get(w) != null) {
                    answer.add(map.get(w));
                    msg = msg.substring(w.length());
                    if (!msg.isEmpty()) {
                        map.put(w + msg.charAt(0), map.size() + 1);
                    }
                    break;
                }
            }
        }
        return answer.stream().mapToInt(it -> it).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] kakaos = solution.solution("KAKAO");
        System.out.println(Arrays.toString(kakaos));
    }
}