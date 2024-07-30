package main.java.programmers.level2.n2_배열_자르기;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[Long.valueOf(right - left + 1).intValue()];
        for (long i = left; i <= right; i++) {
            answer[Long.valueOf(i - left).intValue()] =  Long.valueOf(Math.max(i / n + 1, i % n + 1)).intValue();
        }
        return answer;
    }
}