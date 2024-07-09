package main.java.inflearn.Sorting_and_Searching;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 8
 * 20 25 52 30 39 33 43 33
 */
public class Main0605 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        char answer = 'U';
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            if (map.get(tmp) != null) {
                answer = 'D';
                break;
            }
            map.put(tmp, 0);
        }
        System.out.println(answer);
    }

}