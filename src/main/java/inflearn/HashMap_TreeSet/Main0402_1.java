package main.java.inflearn.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

/**
 * AbaAeCe
 * baeeACA
 */
public class Main0402_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        String m = in.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : n.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        String answer = "YES";
        for (char c : m.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                answer = "NO";
                break;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }
        System.out.println(answer);
    }

}