package main.java.programmers.level3.파괴되지_않은_건물;

/**
 * 누적합 알고리즘 사용
 */
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] graph = new int[board.length + 1][board[0].length + 1];
        //누적합을 위한 2차원 graph 배열 초기화
        for (int[] arr : skill) {
            int type = arr[0];
            int r1 = arr[1];
            int c1 = arr[2];
            int r2 = arr[3];
            int c2 = arr[4];
            int degree = arr[5];
            degree = type == 2 ? degree : -degree;
            graph[r1][c1] += degree;
            graph[r2 + 1][c1] += -degree;
            graph[r1][c2 + 1] += -degree;
            graph[r2 + 1][c2 + 1] += degree;
        }
        //가로로 누적합 계산
        for (int i = 0; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                graph[i][j] += graph[i][j-1];
            }
        }
        //새로로 누적합 계산
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 1; i < board.length; i++) {
                graph[i][j] += graph[i-1][j];
            }
        }
        //board에 누적합 결과 덧셈
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + graph[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}