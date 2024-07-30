package main.java.programmers.level2.점프와_순간_이동;

public class Solution {
    public int solution(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                ans++;
            }
        }
        return ++ans;
    }
}