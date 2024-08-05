package main.java.programmers.level2.쿼드압축_후_개수_세기;

class Solution {

    int countZero = 0;
    int countOne = 0;

    public int[] solution(int[][] arr) {
        check(0, 0, arr.length, arr);
        return new int[]{countZero, countOne};
    }

    void check(int x, int y, int len, int[][] arr) {
        //확인
        int tmp = arr[x][y];
        boolean flag = true;
        for (int i = x; i < x + len; i++) {
            if (!flag) break;
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] != tmp) {
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            if (tmp == 0) countZero++;
            else countOne++;
        } else {
            //4개로 쪼개서 check 4번 재귀 호출
            int half = len / 2;
            if (half != 1) {
                check(x, y, half, arr);
                check(x + half, y, half, arr);
                check(x, y + half, half, arr);
                check(x + half, y + half, half, arr);
            } else {
                //최종 계산
                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        if (arr[x + i][y + j] == 0) countZero++;
                        else countOne++;
                    }
                }
            }
        }
    }
}