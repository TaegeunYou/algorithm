package main.java.baekjoon.gold._9328;

import java.io.*;
import java.util.*;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    private void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            List<Node> startNodes = new ArrayList<>();
            char[][] board = new char[h][w];
            boolean[] hasKey = new boolean['z' - 'a' + 1];
            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    board[j][k] = str.charAt(k);
                    if ((j == 0 || k == 0 || j == h - 1 || k == w - 1) && (board[j][k] != '*')) {
                        startNodes.add(new Node(j, k));
                    }
                }
            }
            String str = br.readLine();
            if (!str.equals("0")) {
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    hasKey[c - 'a'] = true;
                }
            }
            int result = execute(startNodes, board, hasKey);
            sb.append(result).append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private int execute(List<Node> startNodes, char[][] board, boolean[] hasKey) {
        int answer = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        Map<Character, List<Node>> map = new HashMap<>();   //키를 얻었을때 방문할 수 있는 방
        Deque<Node> queue = new ArrayDeque<>();
        for (Node node : startNodes) {
            queue.offerLast(node);
        }
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (visited[node.x][node.y]) {
                continue;
            }
            char tmp = board[node.x][node.y];
            if (Character.isUpperCase(tmp) && !hasKey[tmp - 'A']) {
                char lowercase = Character.toLowerCase(tmp);
                List<Node> availNodes = map.getOrDefault(lowercase, new ArrayList<>());
                availNodes.add(node);
                map.put(lowercase, availNodes);
                continue;
            }
            visited[node.x][node.y] = true;
            if (tmp == '$') {
                answer++;
            }
            if (Character.isLowerCase(tmp) && !hasKey[tmp - 'a']) {
                hasKey[tmp - 'a'] = true;
                if (map.get(tmp) != null && !map.get(tmp).isEmpty()) {
                    List<Node> availNodes = map.get(tmp);
                    for (Node availNode : availNodes) {
                        queue.offerLast(availNode);
                    }
                    map.get(tmp).clear();
                }
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) {
                    continue;
                }
                if (board[nx][ny] == '*' || visited[nx][ny]) {
                    continue;
                }
                queue.offerLast(new Node(nx, ny));
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
