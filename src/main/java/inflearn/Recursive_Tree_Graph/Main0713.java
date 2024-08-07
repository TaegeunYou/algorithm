package main.java.inflearn.Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 */
public class Main0713 {

    static int n;
    static int answer;
    static int[] ch;

    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int m = in.nextInt();
        list = new ArrayList<>();
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list.get(a).add(b);
        }
        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }

    static void dfs(int num) {
        if (num == n) {
            answer++;
            return;
        }
        for (int i : list.get(num)) {
            if (ch[i] == 0) {
                ch[i] = 1;
                dfs(i);
                ch[i] = 0;
            }
        }
    }
}