package main.java.algolab.MSTPrim;

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
        int[] nearest = new int[n + 1];         //정점 i와 가장 가까운 정점
        int[] distance = new int[n + 1];        //현재 트리에 연결된 정점들로부터 정점 i까지의 최소 거리
        int sum = 0;

        for (int i = 2; i <= n; i++) {
            nearest[i] = 1;
            distance[i] = W[1][i];
        }

        for (int repeat = 0; repeat < n - 1; repeat++) {
            int min = Integer.MAX_VALUE;
            int vnear = -1;
            for (int i = 2; i <= n; i++) {
                if (0 <= distance[i] && distance[i] < min) {
                    min = distance[i];
                    vnear = i;
                }
            }
            sum += min;
            distance[vnear] = -1;
            for (int i = 2; i <= n; i++) {
                if (W[i][vnear] < distance[i]) {
                    distance[i] = W[i][vnear];
                    nearest[i] = vnear;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        new main().solution();
    }
}
