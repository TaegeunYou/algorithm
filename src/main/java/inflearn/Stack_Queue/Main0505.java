package main.java.inflearn.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * ()(((()())(())()))(())
 */
public class Main0505 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        char before = ' ';
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (before == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
            before = c;
        }
        System.out.println(answer);
    }

}