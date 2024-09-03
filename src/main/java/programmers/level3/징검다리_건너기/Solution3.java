package main.java.programmers.level3.징검다리_건너기;

import java.util.Arrays;

/**
 * 이진탐색
 */
class Solution3 {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        int lt = 0;
        int rt = Arrays.stream(stones).max().getAsInt();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (isPossible(stones, k, mid)) {
                lt = mid + 1;
                answer = mid;
            } else {
                rt = mid - 1;
            }
        }
        return answer;
    }

    private boolean isPossible(int[] stones, int k, int num) {
        int count = 0;
        for (int stone : stones) {
            if (stone < num) {
                count++;
                if (count == k) return false;
            } else {
                count = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int solution = new Solution3().solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
        System.out.println("solution = " + solution);
    }
}