package main.java.inflearn.Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 */
public class Main0502 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {        //문자 or )
                if (c == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        sb.append(c);
                    }
                } else if (stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }
        System.out.println(sb);
    }

}