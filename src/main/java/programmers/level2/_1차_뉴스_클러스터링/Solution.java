package main.java.programmers.level2._1차_뉴스_클러스터링;

import java.util.HashMap;

/**
 * FRANCE	french
 */
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int a = 0;  //교집합
        int b = 0;  //합집합
        HashMap<String, Integer> map1 = getMap(str1);
        HashMap<String, Integer> map2 = getMap(str2);
        for (String s : map1.keySet()) {
            if (map2.get(s) != null) {      //둘 다 있음
                a += Math.min(map1.get(s), map2.get(s));
                b += Math.max(map1.get(s), map2.get(s));
                map2.remove(s);
            } else {    //map1에만 있음
                b += map1.get(s);
            }
        }
        for (String s : map2.keySet()) {    //map2에만 있음
            b += map2.get(s);
        }
        if (a == 0 && b == 0) return 65536;
        return 65536 * a / b;
    }

    HashMap<String, Integer> getMap(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            String tmp = str.substring(i, i+2);
            if (!tmp.matches("[a-zA-Z]+")) continue;
            if (map.get(tmp) == null) map.put(tmp, 1);
            else map.put(tmp, map.get(tmp) + 1);
        }
        return map;
    }
}