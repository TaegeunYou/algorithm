package main.java.inflearn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 10
 * 1 0 1 1 1 0 0 1 1 0
 */
public class Main0207 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int[] array = new int[n];
        array[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] == 0) {
                array[i] = 0;
            } else {
                array[i] = array[i-1] + 1;
            }
        }
        System.out.println(Arrays.stream(array).sum());
    }

}