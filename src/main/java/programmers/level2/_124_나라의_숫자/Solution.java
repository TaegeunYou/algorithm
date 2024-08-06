package main.java.programmers.level2._124_나라의_숫자;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 시간초과
 */
class Solution {
    int[] arr = new int[]{1, 2, 4};
    public String solution(int n) {
        String answer = "";
        int num = 1;
        Queue<String> queue = new LinkedList<>();
        for (int i : arr) {
            queue.offer(Integer.toString(i));
        }
        while (!queue.isEmpty()) {
            String tmp = queue.poll();
            if (num == n) {
                answer = tmp;
                break;
            }
            for (int i : arr) {
                queue.offer(tmp + i);
            }
            num++;
        }
        return answer;
    }

}