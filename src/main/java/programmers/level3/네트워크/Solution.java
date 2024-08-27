package main.java.programmers.level3.네트워크;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                answer++;
                dfs(i, computers, ch, n);
            }
        }
        return answer;
    }

    private void dfs(int x, int[][] computers, int[] ch, int n) {
        ch[x] = 1;
        for (int i = 0; i < n; i++) {
            if (computers[i][x] == 1 && ch[i] == 0) {
                dfs(i, computers, ch, n);
            }
        }
    }
}