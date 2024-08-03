package main.java.programmers.level2._2_x_n_타일링;

class Solution {

    public int solution(int n) {
        long[] arr = new long[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 1000000007;
        }
        return (int) arr[n];
    }

}