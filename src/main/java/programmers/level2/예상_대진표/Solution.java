package main.java.programmers.level2.예상_대진표;

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        if (a > b) {
            int c = a;
            a = b;
            b = c;
        }
        while (b - a != 1 || a / 2 == b / 2) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }
        return answer;
    }
}