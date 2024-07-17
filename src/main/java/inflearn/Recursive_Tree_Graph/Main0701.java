package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

public class Main0701 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        recursive(n);
    }

    static void recursive(int num) {
        if (num > 1) {
            recursive(num - 1);
        }
        System.out.print(num + " ");
    }

}