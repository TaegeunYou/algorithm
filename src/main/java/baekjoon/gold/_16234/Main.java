package main.java.baekjoon.gold._16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int L;
    int R;
    List<Node> list = new ArrayList<>();

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        L = Integer.parseInt(st1.nextToken());
        R = Integer.parseInt(st1.nextToken());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int result = 0;
        while (execute(n, arr)) {
            result++;
        }
        System.out.println(result);
    }

    private boolean execute(int n, int[][] arr) {
        boolean flag = false;
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    list.clear();
                    list.add(new Node(i, j));
                    dfs(i, j, arr, visited);
                    if (list.size() != 1) {
                        flag = true;
                    }
                    divide(list, arr);
                }
            }
        }
        return flag;
    }

    private void divide(List<Node> list, int[][] arr) {
        int result = 0;
        for (Node node : list) {
            result += arr[node.x][node.y];
        }
        result /= list.size();
        for (Node node : list) {
            arr[node.x][node.y] = result;
        }
    }

    private void dfs(int x, int y, int[][] arr, boolean[][] visited) {
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length) {
                if (visited[nx][ny]) {
                    continue;
                }
                int diff = Math.abs(arr[x][y] - arr[nx][ny]);
                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    list.add(new Node(nx, ny));
                    dfs(nx, ny, arr, visited);
                }
            }
        }
    }

    private class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
