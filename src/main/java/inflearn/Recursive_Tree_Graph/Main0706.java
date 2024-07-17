package main.java.inflearn.Recursive_Tree_Graph;

import java.util.Scanner;

public class Main0706 {
    static int n;
    static int[] arr;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n + 1];
        dfs(1);
    }

    static void dfs(int num) {
        if (num == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (arr[i] != 0) {
                    tmp += (i + " ");
                }
            }
            System.out.println(tmp);
            return;
        }
        arr[num] = 1;
        dfs(num + 1);
        arr[num] = 0;
        dfs(num + 1);
    }

}