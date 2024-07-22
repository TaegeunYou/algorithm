package main.java.inflearn.Recursive_Tree_Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 6 9
 * 1 3
 * 1 4
 * 2 1
 * 2 5
 * 3 4
 * 4 5
 * 4 6
 * 6 2
 * 6 5
 */
public class Main0714_1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] ch = new int[n + 1];
        int[] dis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            list.get(in.nextInt()).add(in.nextInt());
        }
        queue.offer(1);
        ch[1] = 1;
        dis[1] = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i : list.get(tmp)) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dis[i] = dis[tmp] + 1;
                    queue.offer(i);
                    System.out.println(i + " : " + dis[i]);
                }
            }
        }
    }
}