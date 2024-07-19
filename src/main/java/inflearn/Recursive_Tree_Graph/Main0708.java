package main.java.inflearn.Recursive_Tree_Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main0708 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int level = 0;
        queue.offer(s);
        map.put(s, level++);
        while (map.get(e) == null) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                if (map.get(tmp - 1) == null) {
                    map.put(tmp - 1, level);
                    queue.offer(tmp - 1);
                }
                if (map.get(tmp + 1) == null) {
                    map.put(tmp + 1, level);
                    queue.offer(tmp + 1);
                }
                if (map.get(tmp + 5) == null) {
                    map.put(tmp + 5, level);
                    queue.offer(tmp + 5);
                }
            }
            level++;
        }
        System.out.println(map.get(e));
    }

}