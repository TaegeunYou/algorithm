package main.java.programmers.level2.피로도;

/**
 * 80	[[80,20],[50,40],[30,10]]
 */
class Solution {
    int n;
    int[][] arr;
    int[] ch;
    int k;
    int max = Integer.MIN_VALUE;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        arr = new int[n][2];
        ch = new int[n + 1];
        this.k = k;
        dfs(0, dungeons);
        return max;
    }

    public void dfs(int idx, int[][] dungeons) {
        if (idx == n) {
            check();
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                arr[idx] = dungeons[i];
                ch[i] = 1;
                dfs(idx + 1, dungeons);
                ch[i] = 0;
            }
        }
    }

    public void check() {
        int count = 0;
        int tmp = k;
        for (int[] list : arr) {
            int limit = list[0];
            int use = list[1];
            if (tmp >= limit) {
                tmp -= use;
                count++;
            } else {
                break;
            }
        }
        max = Math.max(max, count);
    }
}