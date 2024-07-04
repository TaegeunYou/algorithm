package main.java.inflearn;

import java.util.Scanner;

/**
 * 8
 * 130 135 148 140 145 150 150 153
 */
public class Main0202 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int max = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            if (tmp > max) {
                count++;
                max = tmp;
            }
        }
        System.out.println(count);
    }

}