package main.java.programmers.level3.가장_긴_팰린드롬;

class Solution {
    char[] arr;
    public int solution(String s) {
        int answer = 1;
        arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            answer = Math.max(answer, execute(i - 1, i + 1, false));
            answer = Math.max(answer, execute(i, i + 1,  true));
        }
        return answer;
    }

    private int execute(int lt, int rt, boolean isNoMid) {
        int result = isNoMid ? 0 : 1;
        while (lt >= 0 && rt < arr.length) {
            if (arr[lt] != arr[rt]) break;
            lt--;
            rt++;
            result += 2;
        }
        return result;
    }

}