package main.java.programmers.level2.줄_서는_방법;

import java.util.Arrays;

//시간 초과
class Solution {

    int[] ch;
    long seq = 1;
    int[] arr;
    int[] answer;
    boolean flag = false;

    public int[] solution(int n, long k) {
        ch = new int[n + 1];
        arr = new int[n];
        dfs(0, n, k);
        return answer;
    }

    private void dfs(int idx, int n, long k) {
        if (flag) return;
        if (idx == n) {
            if (seq++ == k) {
                answer = Arrays.copyOf(arr, n);
                flag = true;
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                arr[idx] = i;
                dfs(idx + 1, n, k);
                ch[i] = 0;
            }
        }
    }

}