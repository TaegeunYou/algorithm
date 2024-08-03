package main.java.programmers.level2.삼각_달팽이;

class Solution {
    public int[] solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += i;
        }
        int[] answer = new int[count];
        int tmp = 1;
        int idx = 0;
        int action = 0;
        int level = 1;
        answer[idx] = tmp;
        while (true) {
            if (tmp >= count) break;
            if (action == 0) {
                if (idx + level < count && answer[idx + level] == 0) {
                    idx += level;
                    answer[idx] = ++tmp;
                    level++;
                } else {
                    action = 1;
                }
            } else if (action == 1) {
                if (idx + 1 < count && answer[idx + 1] == 0) {
                    idx++;
                    answer[idx] = ++tmp;
                } else {
                    action = 2;
                }
            } else {
                if (idx - level >= 0 && answer[idx - level] == 0) {
                    idx -= level;
                    answer[idx] = ++tmp;
                    level--;
                } else {
                    action = 0;
                }
            }
        }
        return answer;
    }

}