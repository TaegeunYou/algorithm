package main.java.programmers.level2.숫자의_표현;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 1;
        int lt = 0;
        int rt = 1;
        while (lt != rt) {
            if (rt > n) break;
            if (sum == n) {
                sum -= lt++;
                sum += ++rt;
                answer++;
            } else if (sum < n) {
                sum += ++rt;
            } else {
                sum -= lt++;
            }
        }
        if (n == 1) return 1;
        return ++answer;
    }
}
