package main.java.programmers.level2.디펜스_게임;

import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;
        for (int tmp : enemy) {
            if (queue.isEmpty() || queue.size() < k) {
                queue.offer(tmp);
            } else if (queue.peek() < tmp) {
                sum += queue.poll();
                queue.offer(tmp);
            } else {
                sum += tmp;
            }
            if (sum > n) break;
            answer++;
        }
        return answer;
    }
}