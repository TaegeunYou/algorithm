package main.java.programmers.level3.파괴되지_않은_건물;

/**
 * 브루트 포스
 * 시간 초과
 */
class Solution2 {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        for (int[] arr : skill) {
            int type = arr[0];
            int r1 = arr[1];
            int c1 = arr[2];
            int r2 = arr[3];
            int c2 = arr[4];
            int degree = arr[5];
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (type == 1) {
                        board[i][j] -= degree;
                    } else {
                        board[i][j] += degree;
                    }
                }
            }
        }
        for (int[] arr : board) {
            for (int i : arr) {
                if (i > 0) answer++;
            }
        }
        return answer;
    }
}