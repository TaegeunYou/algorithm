package main.java.programmers.level3.입국심사;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long lt = 0;
        long rt = 1000000000000000000L;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long result = execute(mid, times);
            if (result < n) {
                lt = mid + 1;
            } else {
                answer = mid;
                rt = mid - 1;
            }
        }
        return answer;
    }

    private long execute(long num, int[] times) {
        long result = 0;
        for (int i : times) {
            result += (num / i);
        }
        return result;
    }
}