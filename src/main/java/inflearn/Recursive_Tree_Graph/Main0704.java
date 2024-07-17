package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

public class Main0704 {

    static int[] fibo;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        fibo = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            System.out.print(recursive(i) + " ");
        }
    }

    static int recursive(int num) {
        if (num == 1 || num == 2) return fibo[num] = 1;
        if (fibo[num] != 0) return fibo[num];
        return fibo[num] = recursive(num - 1) + recursive(num - 2);
    }

}