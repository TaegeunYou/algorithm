package main.java.baekjoon.gold._16920;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int m;
    int p;
    int[] sArr;
    char[][] board;
    List<Node> startNodes;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int[] answerArr;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        sArr = new int[p + 1];
        for (int i = 1; i <= p; i++) {
            sArr[i] = Integer.parseInt(st.nextToken());
        }
        board = new char[n][m];
        startNodes = new ArrayList<>();
        answerArr = new int[p + 1];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] != '.' && board[i][j] != '#') {
                    int num = board[i][j] - '0';
                    startNodes.add(new Node(i, j, num));
                    answerArr[num]++;
                }
            }
        }
        execute();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= p; i++) {
            sb.append(answerArr[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private void execute() {
        startNodes.sort(Comparator.naturalOrder());
        Deque<Node> queue = new ArrayDeque<>();
        for (Node node : startNodes) {
            queue.offerLast(node);
        }
        while (!queue.isEmpty()) {
            List<Node> nodes = new ArrayList<>();
            Node node = queue.pollFirst();
            nodes.add(node);
            while (!queue.isEmpty() && queue.getFirst().num == node.num) {
                nodes.add(queue.pollFirst());
            }
            Deque<Node> tmpQueue = bfs(nodes, sArr[node.num]);
            int len = tmpQueue.size();
            for (int i = 0; i < len; i++) {
                queue.offerLast(tmpQueue.pollFirst());
            }
        }
    }

    private Deque<Node> bfs(List<Node> nodes, int totalCount) {
        Deque<Node> queue = new ArrayDeque<>();
        for (Node node : nodes) {
            queue.offerLast(node);
        }
        for (int k = 0; k < totalCount; k++) {
            int len = queue.size();
            if (len == 0) {
                break;
            }
            for (int j = 0; j < len; j++) {
                Node node = queue.pollFirst();
                for (int i = 0; i < dx.length; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                        continue;
                    }
                    if (board[nx][ny] != '.') {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny, node.num));
                    board[nx][ny] = (char) (node.num + '0');
                    answerArr[node.num]++;
                }
            }
        }
        return queue;
    }


    private class Node implements Comparable<Node> {
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
