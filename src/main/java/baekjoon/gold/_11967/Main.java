package main.java.baekjoon.gold._11967;

import java.io.*;
import java.util.*;

public class Main {

    int n;
    int m;
    Map<String, List<String>> map;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    Deque<Node> queue;
    boolean[][] board;
    boolean[][] visited;
    int count = 1;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            String key = x + " " + y;
            List<String> rooms = map.getOrDefault(key, new ArrayList<>());
            rooms.add(a + " " + b);
            map.put(key, rooms);
        }
        process();
        System.out.println(count);
    }
    
    private void process() {
        queue = new ArrayDeque<>();
        board = new boolean[n][n];
        visited = new boolean[n][n];
        board[0][0] = true;
        queue.offerLast(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            if (visitAvail(node)) {
                bfs(node);
            }
        }
    }

    private boolean visitAvail(Node node) {
        if (node.x == 0 && node.y == 0) {
            return true;
        }
        for (int i = 0; i < dx.length; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                continue;
            }
            if (visited[nx][ny]) {
                return true;
            }
        }
        return false;
    }

    private void bfs(Node startNode) {
        Deque<Node> visitQueue = new ArrayDeque<>();
        visitQueue.offerLast(startNode);
        turnOn(startNode);
        visited[startNode.x][startNode.y] = true;
        while (!visitQueue.isEmpty()) {
            Node node = visitQueue.pollFirst();
            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (visited[nx][ny] || !board[nx][ny]) {
                    continue;
                }
                Node tmp = new Node(nx, ny);
                visitQueue.offerLast(tmp);
                turnOn(tmp);
                visited[tmp.x][tmp.y] = true;
            }
        }
    }

    private void turnOn(Node node) {
        String key = node.x + " " + node.y;
        if (map.get(key) != null) {
            List<String> rooms = map.get(key);
            for (String room : rooms) {
                String[] split = room.split(" ");
                int a = Integer.parseInt(split[0]);
                int b = Integer.parseInt(split[1]);
                if (!board[a][b]) {
                    board[a][b] = true;
                    count++;
                    queue.offerLast(new Node(a, b));
                }
            }
        }
    }

    private class Node {
        int x;
        int y;
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
