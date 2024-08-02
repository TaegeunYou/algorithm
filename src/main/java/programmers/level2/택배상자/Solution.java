package main.java.programmers.level2.택배상자;

import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int expectIdx = 0;
        Stack<Integer> sub = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            boolean flag = true;
            if (i == order[expectIdx]) {
                expectIdx++;
                flag = false;
            }
            while (!sub.isEmpty() && sub.peek() == order[expectIdx]) {
                sub.pop();
                expectIdx++;
                flag = false;
            }
            if (flag) sub.push(i);
        }
        return expectIdx;
    }
}