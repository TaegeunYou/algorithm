package main.java.programmers.level2.메뉴_리뉴얼;

import java.util.*;

class Solution {

    HashMap<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        int[] courses = new int[28];
        for (int i : course) {
            courses[i] = 1;
        }
        for (String str : orders) {
            dfs(0, "", str, courses);
        }
        ArrayList<String> list = new ArrayList<>();
        int[] max = new int[28];
        for (String key : map.keySet()) {
            max[key.length()] = Math.max(max[key.length()], map.get(key));
        }
        for (String key : map.keySet()) {
            int count = key.length();
            if (map.get(key) >= 2 && max[count] == map.get(key)) list.add(key);
        }
        String[] answer = list.toArray(new String[0]);
        Arrays.sort(answer);
        return answer;
    }

    private void dfs(int idx, String tmp, String full, int[] courses) {
        if (idx == full.length()) {
            if (courses[tmp.length()] == 1) {
                char[] charArray = tmp.toCharArray();
                Arrays.sort(charArray);
                String s = new String(charArray);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
            return;
        }
        dfs(idx + 1, tmp + full.charAt(idx), full, courses);
        dfs(idx + 1, tmp, full, courses);
    }

}
