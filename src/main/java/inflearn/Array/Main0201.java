package main.java.inflearn.Array;

import java.util.Scanner;

/**
 * 6
 * 7 3 9 5 6 12
 */
public class Main0201 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int bf = 0;
        for (int i = 0; i < n; i++) {
            int tmp = in.nextInt();
            if (tmp > bf) {
                System.out.print(tmp + " ");
            }
            bf = tmp;
        }
    }

}