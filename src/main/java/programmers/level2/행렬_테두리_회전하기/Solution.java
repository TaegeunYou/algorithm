package main.java.programmers.level2.행렬_테두리_회전하기;

import java.util.HashMap;

class Solution {

    HashMap<String, Integer> map;
    int min;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int answerIdx = 0;
        int[][] board = new int[rows + 1][columns + 1];
        int tmp = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                board[i][j] = tmp++;
            }
        }
        for (int[] arr : queries) {
            int x1 = arr[0];
            int y1 = arr[1];
            int x2 = arr[2];
            int y2 = arr[3];
            map = new HashMap<>();
            min = Integer.MAX_VALUE;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    int result = board[i][j];
                    if (i == x1 && j == y1) {       //11시 구석
                        put(i, j + 1, result);
                    } else if (i == x1 && j == y2) {    //1시 구석
                        put(i + 1, j, result);
                    } else if (i == x2 && j == y2) {    //5시 구석
                        put(i, j - 1, result);
                    } else if (i == x2 && j == y1) {    //7시 구석
                        put(i - 1, j, result);
                    } else if (i == x1) {       //12시
                        put(i, j + 1, result);
                    } else if (j == y2) {       //3시
                        put(i + 1, j, result);
                    } else if (i == x2) {       //6시
                        put(i, j - 1, result);
                    } else if (j == y1) {       //9시
                        put(i - 1, j, result);
                    }
                }
            }
            for (String str : map.keySet()) {
                String[] split = str.split("-");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                board[x][y] = map.get(str);
            }
            answer[answerIdx++] = min;
        }
        return answer;
    }

    private void put(int x, int y, int result) {
        map.put(x + "-" + y, result);
        min = Math.min(min, result);
    }

}