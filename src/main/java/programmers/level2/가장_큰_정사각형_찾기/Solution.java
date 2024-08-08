package main.java.programmers.level2.가장_큰_정사각형_찾기;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    if (i != 0 && j != 0) {
                        board[i][j] = Math.min(
                            board[i - 1][j - 1], Math.min(
                                board[i - 1][j], board[i][j - 1]
                            )
                        ) + 1;
                    }
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        return (int) Math.pow(max, 2);
    }

}