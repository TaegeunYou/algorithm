package main.java.algolab.ShortestPathDijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int nodes = Integer.parseInt(br.readLine());
            int[][] arr = new int[nodes + 1][nodes + 1];
            for (int j = 0; j < nodes; j++) {
                Arrays.fill(arr[j + 1], Integer.MAX_VALUE);
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int connects = Integer.parseInt(st.nextToken());
                arr[a][a] = 0;
                for (int k = 0; k < connects; k++) {
                    int b = Integer.parseInt(st.nextToken());
                    int dist = Integer.parseInt(st.nextToken());
                    arr[a][b] = dist;
                }
            }
            int result = prim(nodes, arr);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    private int prim(int n, int[][] W) {
        int[] touch = new int[n + 1];
        int[] length = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            touch[i] = 1;
            length[i] = W[1][i];
        }

        for (int repeat = 0; repeat < n - 1; repeat++) {
            int min = Integer.MAX_VALUE;
            int vnear = -1;
            for (int i = 2; i <= n; i++) {
                if (0 <= length[i] && length[i] < min) {
                    min = length[i];
                    vnear = i;
                }
            }
            for (int i = 2; i <= n; i++) {
                if (W[vnear][i] == Integer.MAX_VALUE) {
                    continue;
                }
                if (length[vnear] + W[vnear][i] < length[i]) {
                    length[i] = length[vnear] + W[vnear][i];
                    touch[i] = vnear;
                }
            }
            length[vnear] = -1;
        }

        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum += W[touch[i]][i];
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}