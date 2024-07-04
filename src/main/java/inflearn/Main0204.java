package main.java.inflearn;

import java.util.Scanner;

/**
 * 10
 */
public class Main0204 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

}