package main.java.inflearn.HashMap_TreeSet;

import java.util.*;

/**
 * 10 3
 * 13 15 34 23 45 65 33 11 26 42
 */
public class Main0405 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        TreeSet<Integer> sums = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int l = j + 1; l < n; l++) {
                    sums.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }
        if (k > sums.size()) {
            System.out.println(-1);
        } else {
            int idx = 0;
            for (int i : sums) {
                if (idx++ + 1 == k) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

}