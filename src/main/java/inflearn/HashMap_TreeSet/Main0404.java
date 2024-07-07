package main.java.inflearn.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

/**
 * bacaAacba
 * abc
 */
public class Main0404 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int answer = 0;
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length() - 1; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = t.length() - 1; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.equals(tMap)) {
                answer++;
            }
            char tmp = s.charAt(i - t.length() + 1);
            map.put(tmp, map.get(tmp) - 1);
            if (map.get(tmp) == 0) {
                map.remove(tmp);
            }
        }
        System.out.println(answer);
    }

}