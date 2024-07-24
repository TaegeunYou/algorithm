package main.java.inflearn.Greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 5
 * 14 18
 * 12 15
 * 15 20
 * 20 30
 * 5 14
 */
class Main0903 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] times = new int[73];
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            for (int j = start; j < end; j++) {
                times[j]++;
            }
        }
        System.out.println(Arrays.stream(times).max().getAsInt());
    }

}