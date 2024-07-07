package main.java.inflearn.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * (()(()))(()
 */
public class Main0501_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            answer = "NO";
        }
        System.out.println(answer);
    }

}