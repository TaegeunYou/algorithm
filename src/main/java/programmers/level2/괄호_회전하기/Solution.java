package main.java.programmers.level2.괄호_회전하기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }
        for (int i = 0; i < s.length(); i++) {
            if (check(queue)) answer++;
            queue.offer(queue.poll());
        }
        return answer;
    }

    public boolean check(Queue<Character> list) {
        Stack<Character> stack = new Stack<>();
        for (char c : list) {
            if (!stack.isEmpty()) {
                if (stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}