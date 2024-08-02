package main.java.programmers.level2.더_맵게;

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.offer(i);
        }
        while (queue.size() >= 2 && queue.peek() < K) {
            int a = queue.poll();
            int b = queue.poll();
            queue.offer(a + b * 2);
            answer++;
        }
        if (queue.isEmpty() || queue.peek() < K) return -1;
        return answer;
    }
}