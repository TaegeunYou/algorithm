package main.java.programmers.level3.징검다리_건너기;

import java.util.Collections;
import java.util.TreeMap;

/**
 * 연속된 k개의 징검다리가 0이면 건널 수 없음
 * -> k개의 연속된 원소중의 최댓값이 가장 작은 경우
 *
 * 시간초과
 */
class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MIN_VALUE;
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i <= k - 1; i++) {
            int tmpStone = stones[i];
            answer = Math.max(answer, tmpStone);
            map.put(tmpStone, map.getOrDefault(tmpStone, 0) + 1);
        }
        for (int i = k; i < stones.length; i++) {
            int removeStone = stones[i - k];
            int addStone = stones[i];
            if (map.get(removeStone) == 1) {
                map.remove(removeStone);
            } else {
                map.put(removeStone, map.get(removeStone) - 1);
            }
            map.put(addStone, map.getOrDefault(addStone, 0) + 1);
            answer = Math.min(answer, map.firstKey());
        }
        return answer;
    }
}