package main.java.programmers.level3.합승_택시_요금;

import java.util.Arrays;

/**
 * 모든 지점에서 모든 지점으로의 최단 거리를 알아야 함 : 플로이드 와샬 알고리즘
 * 이 알고리즘의 시간 복잡도는 O(n^3) -> 정점의 개수가 약 500개 까지 가능
 */
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], 100000000);       //Integer.MAX_VALUE로 설정시 합 계산시에 overflow로 문제 발생
        }
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }
        for (int[] arr : fares) {
            graph[arr[0]][arr[1]] = arr[2];
            graph[arr[1]][arr[0]] = arr[2];
        }
        for (int k = 1; k <= n; k++) {          //k를 거쳐서
            for (int i = 1; i <= n; i++) {      //i에서
                for (int j = 1; j <= n; j++) {  //j로 가는 최단거리
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        return answer;
    }

}