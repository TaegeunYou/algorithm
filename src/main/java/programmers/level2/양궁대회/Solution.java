package main.java.programmers.level2.양궁대회;

import java.util.Arrays;

class Solution {
    int n;
    int[] info;
    int[] lionInfo;
    int maxDiff = Integer.MIN_VALUE;
    int[] answer = null;
    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;
        lionInfo = new int[11];
        dfs(0, n);
        return answer == null ? new int[]{ -1 } : answer;
    }

    /**
     * @param idx       현재 과녁 idx 0 : 10점, idx 1 : 9점 ... idx 10 : 0점
     * @param remainN
     */
    private void dfs(int idx, int remainN) {
        if (remainN == 0) {
            //점수 차이 계산
            int diff = 0;
            for (int i = 0; i < 10; i++) {
                int score = 10 - i;
                int apeach = info[i];
                int lion = lionInfo[i];
                if (apeach == 0 && lion == 0) continue;
                if (apeach >= lion) {
                    diff -= score;
                } else {
                    diff += score;
                }
            }
            if (diff > 0 && diff >= maxDiff) {
                if (diff == maxDiff) {
                    StringBuilder lionReverseStr = new StringBuilder(Arrays.toString(lionInfo)).reverse();
                    StringBuilder answerReverseStr = new StringBuilder(Arrays.toString(answer)).reverse();
                    if (answerReverseStr.compareTo(lionReverseStr) > 0) return;
                }
                maxDiff = diff;
                answer = Arrays.copyOf(lionInfo, lionInfo.length);
            }
            return;
        }
        if (idx == 10) {
            lionInfo[idx] = remainN;
            dfs(idx + 1, 0);
            lionInfo[idx] = 0;
        } else {
            for (int i = remainN; i >= 0; i--) {
                lionInfo[idx] = i;
                dfs(idx + 1, remainN - i);
                lionInfo[idx] = 0;
            }
        }
    }
}