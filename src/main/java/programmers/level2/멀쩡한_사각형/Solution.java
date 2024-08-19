package main.java.programmers.level2.멀쩡한_사각형;

/**
 * 흰 정사각형 개수 : 절편 개수 + 꼭짓점 개수 + 1
 */
class Solution {
    public long solution(int w, int h) {
        long a = Math.max(w, h);
        long b = Math.min(w, h);
        long x = get(a, b) - 1;     //꼭짓점 개수
        long y = (a - 1) * 2 - (a - b) - x * 2;     //절편 개수
        return (long) w * h - (x + y + 1);
    }

    private long get(long big, long small) {
        for (long i = small; i >= 1; i--) {
            if (big % i == 0 && small % i == 0) return i;
        }
        return -1;
    }
}