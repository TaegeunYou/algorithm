package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

public class Main0702 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        recursive(n);
    }

    static void recursive(int num) {
        if (num == 0) return;
        recursive(num / 2);
        System.out.print(num % 2 + " ");
    }

}