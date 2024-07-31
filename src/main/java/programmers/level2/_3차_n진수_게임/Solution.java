package main.java.programmers.level2._3차_n진수_게임;

/**
 * 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
 * 2	4	2	1
 */

//한줄로해서 10만
class Solution {
    int n;
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int count = 0;
        int num = 0;
        this.n = n;
        while (answer.length() < t) {
            String str = change(num++);
            for (char c : str.toCharArray()) {
                if (count % m == p-1) {
                    answer += c;
                    if (answer.length() == t) {
                        break;
                    }
                }
                count++;
            }
        }
        return answer;
    }

    public String change(int num) {
        String tmp = "";
        if (num == 0) return "0";
        while (num != 0) {
            int remain = num % n;
            if (remain >= 10) {
                tmp = (char) ('A' + (remain - 10)) + tmp;
            } else {
                tmp = remain + tmp;
            }
            num /= n;
        }
        return tmp;
    }
}