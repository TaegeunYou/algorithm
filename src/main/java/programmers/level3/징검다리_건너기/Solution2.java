package main.java.programmers.level3.징검다리_건너기;

import java.util.ArrayDeque;

/**
 * 슬라이딩 윈도우 + 최댓값
 */
class Solution2 {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        ArrayDeque<Stone> dq = new ArrayDeque<>();
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];

            //dq의 사이즈가 아니라 윈도우의 사이즈 유지
            if (!dq.isEmpty() && i - dq.peekFirst().idx == k) dq.pollFirst();

            //dq를 내림차순으로 유지 (윈도우의 모든 원소를 갖고 있을 필요가 없다)
            while (!dq.isEmpty() && stone > dq.peekLast().value) {
                dq.pollLast();
            }

            dq.offerLast(new Stone(i, stone));

            if (i + 1 >= k) {
                answer = Math.min(answer, dq.peekFirst().value);
            }
        }
        if (answer == Integer.MAX_VALUE) answer = 0;
        return answer;
    }

    class Stone {
        int idx;
        int value;

        public Stone(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}