package main.java.programmers.level3.거스름돈;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 시간초과
 */
class Solution {
    int n;
    int[] money;
    int answer = 0;

    public int solution(int n, int[] money) {
        this.n = n;
        Integer[] array = Arrays.stream(money).boxed().toArray(Integer[]::new);
        Arrays.sort(array, Comparator.reverseOrder());
        this.money = Arrays.stream(array).mapToInt(it -> it).toArray();
        dfs(0, n);
        return answer;
    }

    private void dfs(int idx, int remain) {
        if (idx == money.length && remain != 0) return;
        if (remain == 0) {
            answer = (answer + 1) % 1000000007;
            return;
        }
        int num = money[idx];
        int share = remain / num;
        for (int i = share; i >= 0; i--) {
            dfs(idx + 1, remain - num * i);
        }
    }

}
