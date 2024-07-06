package main.java.inflearn.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 15
 * BACBACCACCBDEDE
 */
public class Main0401 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String m = in.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : m.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        char answer = ' ';
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        System.out.println(answer);
    }

}