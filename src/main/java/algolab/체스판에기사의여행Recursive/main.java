package main.java.algolab.체스판에기사의여행Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {
    int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int[][] arr = new int[m][n];
            arr[a][b] = 1;
            int result = recursive(m, n, a, b, arr, 1);
            sb.append(result).append("\n");
            if (result == 1) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        sb.append(arr[j][k]).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\n");
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        br.close();
        System.out.println(sb);
    }

    private int recursive(int m, int n, int x, int y, int[][] arr, int num)  {
        if (num == m * n) {
            return 1;
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                arr[nx][ny] = num + 1;
                int result = recursive(m, n, nx, ny, arr, num + 1);
                if (result == 1) return result;
                arr[nx][ny] = 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}
