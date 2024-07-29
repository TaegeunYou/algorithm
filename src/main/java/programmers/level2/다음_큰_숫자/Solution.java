package main.java.programmers.level2.다음_큰_숫자;

class Solution {
    public int solution(int n) {
        int answer = n + 1;
        int count = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') count++;
        }
        while (true) {
            int tmpCount = 0;
            for (char c : Integer.toBinaryString(answer).toCharArray()) {
                if (c == '1') tmpCount++;
            }
            if (count == tmpCount) {
                break;
            } else {
                answer++;
            }
        }
        return answer;
    }
}
