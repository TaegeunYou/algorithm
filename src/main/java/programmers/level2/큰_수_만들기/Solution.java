package main.java.programmers.level2.큰_수_만들기;

import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        Stack<Character> stack = new Stack<>();
        int size = number.length() - k;
        for (int i = 0; i < len; i++) {
            char tmp = number.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() < tmp) {
                stack.pop();
                k--;
            }
            stack.push(tmp);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }
        return sb.substring(0, size);
    }
}