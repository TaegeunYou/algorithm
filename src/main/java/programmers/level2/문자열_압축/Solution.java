package main.java.programmers.level2.문자열_압축;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            String str = "";
            String before = "";
            int count = 1;
            for (int j = 0; j < s.length(); j += i) {
                String tmp = s.substring(j, Math.min(j + i, s.length()));
                if (!tmp.equals(before)) {
                    if (count > 1) {
                        str += (count + before);
                        count = 1;
                    } else {
                        str += before;
                    }
                } else {
                    count++;
                }
                before = tmp;
            }
            if (count > 1) {
                str += (count + before);
            } else {
                str += before;
            }
            answer = Math.min(answer, str.length());
        }
        return answer;
    }
}