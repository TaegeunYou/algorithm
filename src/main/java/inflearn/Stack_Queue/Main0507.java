package main.java.inflearn.Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * CBA
 * CBDAGE
 */
public class Main0507 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String order = in.next();
        String str = in.next();
        Queue<Character> queue = new LinkedList<>();
        for (char c : order.toCharArray()) {
            queue.offer(c);
        }
        for (char c : str.toCharArray()) {
            if (!queue.isEmpty() && c == queue.peek()) {
                queue.poll();
            }
        }
        String answer = "YES";
        if (!queue.isEmpty()) {
            answer = "NO";
        }
        System.out.println(answer);
    }

}