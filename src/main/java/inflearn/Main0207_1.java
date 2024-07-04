package main.java.inflearn;

import java.util.Scanner;

/**
 * 10
 * 1 0 1 1 1 0 0 1 1 0
 */
public class Main0207_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            if (tmp == 0) {
                cnt = 0;
            } else {
                cnt++;
                sum += cnt;
            }
        }
        System.out.println(sum);
    }

}