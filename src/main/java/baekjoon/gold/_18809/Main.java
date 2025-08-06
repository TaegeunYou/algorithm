package main.java.baekjoon.gold._18809;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int m;
    int g;
    int r;
    Node[][] board;
    List<Node> avails = new ArrayList<>();
    List<Node> starts = new ArrayList<>();
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int tmpAnswer = 0;
    int answer = 0;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        board = new Node[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                Node node = new Node(i, j, num, 1);
                board[i][j] = node;
                if (num == 2) {
                    avails.add(node);
                }
            }
        }
        combi(0, g, r);
        System.out.println(answer);
    }

    private void process() {
        Node[][] nodeBoard = copyBoard();
        Deque<Node> queue = new ArrayDeque<>();
        for (Node node : starts) {
            queue.offerLast(node);
            nodeBoard[node.x][node.y] = node;
        }
        int seq = 1;
        while (!queue.isEmpty()) {
            seq++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                if (nodeBoard[node.x][node.y].num == 5) {
                    continue;
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    Node tmp = nodeBoard[nx][ny];
                    if (tmp.num == 0 || tmp.num == 5 || tmp.num == node.num) {  //호수 || 꽃 || 동일
                        continue;
                    }
                    if (tmp.num + node.num == 7 && tmp.seq == seq) { // 꽃
                        nodeBoard[nx][ny] = new Node(nx, ny, 5, seq);
                        tmpAnswer++;
                        continue;
                    }
                    if (tmp.num == 1 || tmp.num == 2) { // 퍼지기
                        Node newNode = new Node(nx, ny, node.num, seq);
                        nodeBoard[nx][ny] = newNode;
                        queue.offerLast(newNode);
                    }
                }
            }
        }
    }

    private void combi(int idx, int remainG, int remainR) {
        if (remainG + remainR == 0) {  // 배양액을 다 쓴 경우
            tmpAnswer = 0;
            process();
            answer = Math.max(answer, tmpAnswer);
            return;
        }
        if (idx == avails.size()) {  //뿌릴 곳이 남지 않은 경우
            return;
        }
        Node tmp = avails.get(idx);
        //g
        if (remainG > 0) {
            starts.add(new Node(tmp.x, tmp.y, 3, 1));
            combi(idx + 1, remainG - 1, remainR);
            starts.remove(starts.size() - 1);
        }
        //r
        if (remainR > 0) {
            starts.add(new Node(tmp.x, tmp.y, 4, 1));
            combi(idx + 1, remainG, remainR - 1);
            starts.remove(starts.size() - 1);
        }
        //스킵
        combi(idx + 1, remainG, remainR);
    }

    private Node[][] copyBoard() {
        Node[][] newBoard = new Node[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }

    private class Node {
        int x;
        int y;
        int num;  // 3은 g, 4는 r, 5는 꽃
        int seq;
        public Node(int x, int y, int num, int seq) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.seq = seq;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
