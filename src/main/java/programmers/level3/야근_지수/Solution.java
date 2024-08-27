package main.java.programmers.level3.야근_지수;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : works) {
            queue.offer(i);
        }
        while (n > 0) {
            Integer num = queue.poll();
            Integer next = queue.peek();
            int diff = num - next;
            if (diff == 0) {
                queue.offer(num - 1);
                n--;
            } else if (diff > n) {
                num -= n;
                n = 0;
                queue.offer(num);
            } else  {
                num = next;
                n -= diff;
                queue.offer(num);
            }
        }
        for (int i : queue) {
            if (i > 0) answer += (long) Math.pow(i, 2);
        }
        return answer;
    }

}