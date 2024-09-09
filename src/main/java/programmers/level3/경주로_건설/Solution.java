package main.java.programmers.level3.경주로_건설;

/**
 직선도로 개수 = 이동 횟수
 이전 방향이 있으면서 이전 방향이랑 다르면 코너 추가
 최단거리가 정답이 아닐 수 있음 (코너가 직선보다 비쌈)
 bfs로 하면서 현재 최저 가격보다 비싸면 그 루트는 return 하면 될듯

 시간초과
 */
class Solution {
    int[][] board;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] ch;
    int boardLength;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        this.board = board;
        boardLength = board.length;
        ch = new boolean[boardLength][boardLength];
        ch[0][0] = true;
        dfs(0, 0, 0, 0, 0);
        return answer;
    }

    public void dfs(int x, int y, int beforeDx, int beforeDy, int sum) {
        if (x == boardLength - 1 && y == boardLength - 1) {     //도착점 도착
            answer = Math.min(answer, sum);
            return;
        }
        for (int j = 0; j < dx.length; j++) {
            int nx = x + dx[j];
            int ny = y + dy[j];
            if (nx >= 0 && nx < boardLength && ny >= 0 && ny < boardLength && board[nx][ny] == 0 && !ch[nx][ny]) {
                boolean isCorner = !(x == 0 && y == 0) && !(dx[j] == beforeDx && dy[j] == beforeDy);
                int price = sum + 100 + (isCorner ? 500 : 0);
                if (price >= answer) continue;
                ch[nx][ny] = true;
                dfs(nx, ny, dx[j], dy[j], price);
                ch[nx][ny] = false;
            }
        }
    }

}