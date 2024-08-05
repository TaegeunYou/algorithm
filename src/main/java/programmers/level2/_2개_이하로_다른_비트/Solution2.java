package main.java.programmers.level2._2개_이하로_다른_비트;

import java.util.Arrays;

/**
 * 짝수면 뒤만 1로 바꾸기
 * 홀수면 가장 뒤에 있는 0을 1로 바꾸고 + 그 바로 뒤에 있는 1만 0으로 바꾼다
 *
 *
 * 01 => 10
 * 011 -> 100, 101, 110, 111 => 101
 * 101 -> 110, 111 => 110
 * 0111 -> 1000(4), 1001(3), 1010(3), 1011(2) => 1011
 */
class Solution2 {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                String str = '0' + Long.toBinaryString(numbers[i]);
                for (int j = str.length() - 1; j >= 0; j--) {
                    if (str.charAt(j) == '0'){
                        str = str.substring(0, j) + "10" + str.substring(j + 2);
                        break;
                    }
                }
                answer[i] = Long.parseLong(str, 2);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        long[] solution = new Solution2().solution(new long[]{7});
        String string = Arrays.toString(solution);
        System.out.println("string = " + string);
    }

}