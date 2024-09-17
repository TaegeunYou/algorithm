package main.java.programmers.level2.카카오프렌즈_컬러링북;

class Solution {
    int m;
    int n;
    int[][] picture;
    boolean[][] ch;
    int numberOfArea = 0;
    int maxSizeOfOneArea = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int tmpCount;
    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        this.picture = picture;
        this.ch = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !ch[i][j]) {
                    tmpCount = 1;
                    ch[i][j] = true;
                    dfs(i, j, picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmpCount);
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private void dfs(int x, int y, int color) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !ch[nx][ny] && picture[nx][ny] == color) {
                tmpCount++;
                ch[nx][ny] = true;
                dfs(nx, ny, color);
            }
        }
    }
}