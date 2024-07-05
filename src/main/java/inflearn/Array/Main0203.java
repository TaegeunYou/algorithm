package main.java.inflearn.Array;

import java.util.Scanner;

/**
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 */
public class Main0203 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[5];
        int[] b = new int[5];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if ((a[i] == 2 && b[i] == 1) || (a[i] == 3 && b[i] == 2) || (a[i] == 1 && b[i] == 3)) {
                sb.append("A\n");
            } else if ((b[i] == 2 && a[i] == 1) || (b[i] == 3 && a[i] == 2) || (b[i] == 1 && a[i] == 3)) {
                sb.append("B\n");
            } else {
                sb.append("D\n");
            }
        }
        System.out.println(sb);
    }

}