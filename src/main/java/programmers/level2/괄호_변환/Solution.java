package main.java.programmers.level2.괄호_변환;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        return execute(p);
    }

    private String execute(String str) {
        if (str.isEmpty()) return "";
        String u = "", v = "";
        int flag = 0;
        if (str.charAt(0) == '(') flag++;
        else flag--;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                flag++;
            } else flag--;
            if (flag == 0) {
                u = str.substring(0, i + 1);
                v = str.substring(i + 1);
                break;
            }
        }
        Stack<Character> stack = new Stack<>();
        stack.add(u.charAt(0));
        for (int i = 1; i < u.length(); i++) {
            if (!stack.isEmpty() && stack.peek() == '(' && u.charAt(i) == ')') {
                stack.pop();
            } else {
                stack.push(u.charAt(i));
            }
        }
        //조건 3
        if (stack.isEmpty()) {
            return u + execute(v);
        } else {
            //조건 4
            String a = "(" + execute(v) + ")";
            String b = u.substring(1, u.length() - 1)
                .replace('(', 'a')
                .replace(')', '(')
                .replace('a', ')');
            return a + b;
        }
    }
}