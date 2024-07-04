package main.java.inflearn;

import java.util.Scanner;

/**
 * 20
 */
public class Main0205 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
            boolean is = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    is = false;
                    break;
                }
            }
            if (is) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb);
    }

}