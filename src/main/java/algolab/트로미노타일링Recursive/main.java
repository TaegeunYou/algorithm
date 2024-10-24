package main.java.algolab.트로미노타일링Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class main {

    static int[][] map;
    static int x, y, N;
    static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map[x][y] = -1;
            num = 0;
            recursive(0, 0, N);
            map[x][y] = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.append("\n");
            }
        }
        sb.deleteCharAt(sb.length() - 1);

        System.out.println(sb);
        br.close();
    }

    /**
     * 큰 사각형 안에서 각 잘라진 사각형을 대표하는 중간 4개의 점을 기준으로 각 평면이 모두 0인지 확인
     * -> 확인할때 대표점은 왼쪽 위 구석점을 파라미터로 해서 확인
     * 확인한 평면이 모두 0이면 해당 대표점을 색칠
     *
     * 각 대표점들이 포함된 잘라진 사각형에 대해서 동일한 방법으로 확인함.
     */
    public static void recursive(int x, int y, int size) {
        num++;
        int ns = size / 2;

        if (check(x, y, ns)) map[x + ns - 1][y + ns - 1] = num;
        if (check(x + ns, y, ns)) map[x + ns][y + ns - 1] = num;
        if (check(x, y + ns, ns)) map[x + ns - 1][y + ns] = num;
        if (check(x + ns, y + ns, ns)) map[x + ns][y + ns] = num;

        if (size == 2) return;

        recursive(x, y, ns);
        recursive(x + ns, y, ns);
        recursive(x, y + ns, ns);
        recursive(x + ns, y + ns, ns);
    }

    public static boolean check(int x, int y, int s) {
        for (int i = x; i < x + s; i++) {
            for (int j = y; j < y + s; j++) {
                if (map[i][j] != 0) return false;
            }
        }
        return true;
    }

}
