package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

public class Main0703 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(recursive(n));
    }

    static int recursive(int num) {
        if (num == 1) return 1;
        return num * recursive(num - 1);
    }

}