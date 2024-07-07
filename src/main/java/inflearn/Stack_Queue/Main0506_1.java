package main.java.inflearn.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 8 3
 */
public class Main0506_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            for (int i = 0; i < k - 1; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        System.out.println(queue.peek());
    }

}