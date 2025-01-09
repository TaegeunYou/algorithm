package main.java.baekjoon.gold._1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int max = 1;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st1.nextToken());
        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        boolean[] visited = new boolean['Z' - 'A' + 1];
        visited[arr[0][0] - 'A'] = true;
        dfs(0, 0, arr, visited, 1);
        System.out.println(max);
    }

    private void dfs(int x, int y, char[][] arr, boolean[] visited, int result) {
        max = Math.max(max, result);
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length) {
                char tmp = arr[nx][ny];
                int idx = tmp - 'A';
                if (visited[idx]) {
                    continue;
                }
                visited[idx] = true;
                dfs(nx, ny, arr, visited, result + 1);
                visited[idx] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
