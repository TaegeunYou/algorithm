package main.java.baekjoon.gold._21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < n * n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                int like = Integer.parseInt(st.nextToken());
                list.add(like);
            }
            map.put(student, list);
        }
        int[][] board = process(n, map);
        int result = calculate(board, map);
        System.out.println(result);
    }

    private int[][] process(int n, Map<Integer, List<Integer>> map) {
        int[][] board = new int[n][n];
        for (int student : map.keySet()) {
            List<Integer> likes = map.get(student);
            List<Node> nodes = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] != 0) {
                        continue;
                    }
                    int likeCount = 0;
                    int blankCount = 0;
                    for (int k = 0; k < dx.length; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                            continue;
                        }
                        if (board[nx][ny] == 0) {
                            blankCount++;
                            continue;
                        }
                        if (likes.contains(board[nx][ny])) {
                            likeCount++;
                        }
                    }
                    nodes.add(new Node(likeCount, blankCount, i, j));
                }
            }
            nodes.sort(Comparator.naturalOrder());
            Node node = nodes.get(0);
            board[node.x][node.y] = student;
        }
        return board;
    }

    private int calculate(int[][] board, Map<Integer, List<Integer>> map) {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int student = board[i][j];
                List<Integer> likes = map.get(student);
                int likesCount = 0;
                for (int k = 0; k < dx.length; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                        continue;
                    }
                    if (likes.contains(board[nx][ny])) {
                        likesCount++;
                    }
                }
                if (likesCount == 1) {
                    result += 1;
                } else if (likesCount == 2) {
                    result += 10;
                } else if (likesCount == 3) {
                    result += 100;
                } else if (likesCount == 4) {
                    result += 1000;
                }
            }
        }
        return result;
    }

    private class Node implements Comparable<Node> {
        int likeCount;
        int blankCount;
        int x;
        int y;

        public Node(int likeCount, int blankCount, int x, int y) {
            this.likeCount = likeCount;
            this.blankCount = blankCount;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.likeCount == o.likeCount && this.blankCount == o.blankCount && this.x == o.x) {
                return this.y - o.y;
            }
            if (this.likeCount == o.likeCount && this.blankCount == o.blankCount) {
                return this.x - o.x;
            }
            if (this.likeCount == o.likeCount) {
                return o.blankCount - this.blankCount;
            }
            return o.likeCount - this.likeCount;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
