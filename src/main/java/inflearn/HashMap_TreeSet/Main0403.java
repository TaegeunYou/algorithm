package main.java.inflearn.HashMap_TreeSet;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 7 4
 * 20 12 20 10 23 17 10
 */
public class Main0403 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(map.size() + " ");
        for (int i = k; i < n; i++) {
            map.put(arr[i-k], map.get(arr[i-k]) - 1);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i-k]) == 0) {
                map.remove(arr[i-k]);
            }
            System.out.print(map.size() + " ");
        }
    }

}