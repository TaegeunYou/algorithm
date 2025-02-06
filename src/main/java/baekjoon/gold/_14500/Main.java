package main.java.baekjoon.gold._14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        List<List<Node>> nodesGroup = new ArrayList<>();
        //하늘색 도형
        nodesGroup.add(
            List.of(new Node(0,0), new Node(0,1), new Node(0,2), new Node(0,3))
        );
        //노란색 도형
        nodesGroup.add(
            List.of(new Node(0,0), new Node(0,1), new Node(1,0), new Node(1,1))
        );
        //주황색 도형
        nodesGroup.add(
            List.of(new Node(0,0), new Node(1,0), new Node(2,0), new Node(2,1))
        );
        nodesGroup.add(
            List.of(new Node(0,0), new Node(1,0), new Node(2,0), new Node(2,-1))
        );
        //초록색 도형
        nodesGroup.add(
            List.of(new Node(0,0), new Node(1,0), new Node(1,1), new Node(2,1))
        );
        nodesGroup.add(
            List.of(new Node(0,0), new Node(1,0), new Node(1,-1), new Node(2,-1))
        );
        //분홍색 도형
        nodesGroup.add(
            List.of(new Node(0,0), new Node(0,1), new Node(0,2), new Node(1,1))
        );
        int answer = execute(board, nodesGroup);
        System.out.println(answer);
    }

    private int execute(int[][] board, List<List<Node>> nodesGroup) {
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (List<Node> nodes : nodesGroup) {
                    for (int k = 0; k < 4; k++) {
                        for (Node node : nodes) {
                            int tmp = node.x;
                            node.x = node.y;
                            node.y = tmp * -1;
                        }
                        int sum = 0;
                        boolean flag = true;
                        for (Node node : nodes) {
                            int nx = i + node.x;
                            int ny = j + node.y;
                            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                                flag = false;
                                break;
                            }
                            sum += board[nx][ny];
                        }
                        if (flag) {
                            answer = Math.max(answer, sum);
                        }
                    }
                }
            }
        }
        return answer;
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
