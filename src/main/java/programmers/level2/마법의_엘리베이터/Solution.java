package main.java.programmers.level2.마법의_엘리베이터;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        String str = Integer.toString(storey);
        /**
         * 1자리부터 +를 해서 없앨건지 -를 해서 없앨건지 선택
         * +를 하면 다음자리에 +1 된다.
         */
        boolean plus = false;
        for (int i = str.length() - 1; i >= 0; i--) {
            int tmp = str.charAt(i) - '0';
            if (plus) tmp++;
            if (tmp == 5 && i - 1 >= 0 && str.charAt(i-1) + 1 > '5') {
                answer += (10 - tmp);
                plus = true;
            } else if (tmp <= 5) {
                answer += tmp;
                plus = false;
            } else {
                answer += (10 - tmp);
                plus = true;
            }
        }
        if (plus) answer++;
        return answer;
    }

}