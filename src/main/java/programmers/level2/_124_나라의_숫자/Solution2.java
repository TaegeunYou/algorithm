package main.java.programmers.level2._124_나라의_숫자;

class Solution2 {
    public String solution(int n) {
        int N = n;      //해당 자리수에서 순서
        int tmp = 1;
        int len = 1;
        while (n != 0) {
            tmp *= 3;
            if (N - tmp > 0) {
                N -= tmp;
            } else break;
            len++;
        }
        String base = "1".repeat(len + 1);
        String unsignedString = Integer.toUnsignedString(N - 1, 3);
        String string = Long.toString(Long.parseLong(base) + Long.parseLong(unsignedString));
        String answer = string
            .replace('3', '4')
            .replace('2', '2')
            .replace('1', '1');
        return answer;
    }
    
}