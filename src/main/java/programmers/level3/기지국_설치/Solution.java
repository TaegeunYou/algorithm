package main.java.programmers.level3.기지국_설치;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        answer += count(- w, stations[0], w);
        for (int i = 0; i < stations.length - 1; i++) {
            answer += count(stations[i], stations[i + 1], w);
        }
        answer += count(stations[stations.length - 1], n + w + 1, w);
        return answer;
    }

    private int count(int a, int b, int w) {
        int left = a + w + 1;
        int right = b - w - 1;
        int size = 2 * w + 1;
        if (left > right) return 0;
        int len = right - left + 1;
        return len / size + (len % size > 0 ? 1 : 0);
    }
}