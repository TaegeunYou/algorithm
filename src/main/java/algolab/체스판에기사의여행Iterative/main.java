package main.java.algolab.체스판에기사의여행Iterative;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Result result = iterative(m, n, a, b);
            sb.append(result.type).append("\n");
            if (result.type == 1) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        sb.append(result.arr[j][k]).append(" ");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append("\n");
                }
            }
        }

        br.close();
        System.out.println(sb);
    }

    private Result iterative(int m, int n, int x, int y) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(x, y, 1, new int[m][n]));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            node.arr[node.x][node.y] = node.num;
            if (node.num == m * n) return new Result(1, node.arr);
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && node.arr[nx][ny] == 0) {
                    int[][] copyArray = copyArray(node.arr);
                    stack.push(new Node(nx, ny, node.num + 1, copyArray));
                }
            }
        }
        return new Result(0, null);
    }

    private int[][] copyArray(int[][] arr) {
        int[][] newArray = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArray[i][j] = arr[i][j];
            }
        }
        return newArray;
    }

    class Node {
        int x;
        int y;
        int num;
        int[][] arr;
        public Node(int x, int y, int num, int[][] arr) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.arr = arr;
        }
    }

    class Result {
        int type;
        int[][] arr;

        public Result(int type, int[][] arr) {
            this.type = type;
            this.arr = arr;
        }
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}