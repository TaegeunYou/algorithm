package main.java.programmers.level2.짝지어_제거하기;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) stack.pop();
            else stack.push(c);
        }
        if (stack.isEmpty()) answer = 1;
        return answer;
    }
}