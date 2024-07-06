package main.java.inflearn.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

/**
 * AbaAeCe
 * baeeACA
 */
public class Main0402 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] n = in.next().toCharArray();
        char[] m = in.next().toCharArray();
        HashMap<Character, Integer> nMap = new HashMap<>();
        HashMap<Character, Integer> mMap = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            nMap.put(n[i], nMap.getOrDefault(n[i], 0) + 1);
            mMap.put(m[i], mMap.getOrDefault(m[i], 0) + 1);
        }
        String answer = "YES";
        for (char key : nMap.keySet()) {
            if (!nMap.get(key).equals(mMap.get(key))) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }

}