package main.java.programmers.level3.최고의_집합;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[]{-1};
        int a = s / n;
        int b = s % n;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < n - b) answer[i] = a;
            else answer[i] = a + 1;
        }
        return answer;
    }
}