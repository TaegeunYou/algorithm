package main.java.programmers.level2._1차_캐시;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for (String city : cities) {
            String tmp = city.toLowerCase();
            if (queue.contains(tmp)) {
                answer += 1;
                queue.remove(tmp);
            } else {
                answer += 5;
            }
            queue.offer(tmp);
            if (queue.size() > cacheSize) {
                queue.poll();
            }
        }
        return answer;
    }
}