package main.java.programmers.level3.표현_가능한_이진트리;

class Solution {

    boolean flag = true;

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = execute(numbers[i]);
        }
        return answer;
    }

    private int execute(long num) {
        String str = Long.toBinaryString(num);
        int level = 1;
        while (Math.pow(2, level) - 1 < str.length()) {
            level++;
        }
        int totalNode = (int) Math.pow(2, level) - 1;
        int len = totalNode - str.length();
        for (int i = 0; i < len; i++) {
            str = "0" + str;
        }
        flag = true;
        dq(0, str.length() - 1, str, false);
        if (flag) {
            return 1;
        }
        return 0;
    }

    private void dq(int lt, int rt, String str, boolean dummy) {
        int mid = (lt + rt) / 2;
        if (dummy && str.charAt(mid) != '0') {
            flag = false;
            return;
        }
        if (lt == rt) {
            return;
        }
        boolean tmpDummy = dummy;
        if (str.charAt(mid) == '0') {
            tmpDummy = true;
        }
        dq(lt, mid - 1, str, tmpDummy);
        dq(mid + 1, rt, str, tmpDummy);
    }
}
