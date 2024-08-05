package main.java.programmers.level2._2개_이하로_다른_비트;

/**
 * 시간 초과
 * n이 10^15 여서 1씩 증가하는 방식으로 풀면 안됨
 */
class Solution {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String iString = Long.toBinaryString(numbers[i]);
            long tmp = numbers[i];
            while (true) {
                tmp++;
                String tmpString = Long.toBinaryString(tmp);
                if (check(iString, tmpString)) {
                    answer[i] = tmp;
                    break;
                }
            }
        }
        return answer;
    }

    private boolean check(String a, String b) {
        int count = 0;
        for (int i = 0; i < b.length(); i++) {
            char tmpA = a.length() - i - 1 >= 0 ? a.charAt(a.length() - i - 1) : '0';
            char tmpB = b.charAt(b.length() - i - 1);
            if (tmpA != tmpB) {
                count++;
                if (count > 2) break;
            }
        }
        return count == 1 || count == 2;
    }

    public static void main(String[] args) {
        new Solution().solution(new long[]{26388279066623L});
    }
}