package main.java.baekjoon.gold._16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    int[][] board;
    Shark shark;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        shark = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 9) {
                    shark = new Shark(i, j);
                } else if (tmp != 0) {
                    board[i][j] = tmp;
                }
            }
        }
        int answer = execute();
        System.out.println(answer);
    }

    private int execute() {
        int time = 0;
        while (true) {
            Integer timeCost = findAndEatFish();
            if (timeCost == null) {
                return time;
            }
            time += timeCost;
        }
    }

    private Integer findAndEatFish() {
        boolean[][] visited = new boolean[board.length][board[0].length];
        Deque<Node> nodes = new ArrayDeque<>();
        nodes.offerLast(new Node(shark.x, shark.y));
        int time = 0;
        while (!nodes.isEmpty()) {
            int len = nodes.size();
            List<Node> findFishs = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Node node = nodes.pollFirst();
                if (visited[node.x][node.y]) {
                    continue;
                }
                visited[node.x][node.y] = true;
                if (board[node.x][node.y] != 0 && board[node.x][node.y] < shark.size) {
                    findFishs.add(node);
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length || visited[nx][ny] || board[nx][ny] > shark.size) {
                        continue;
                    }
                    nodes.offerLast(new Node(nx, ny));
                }
            }
            if (!findFishs.isEmpty()) {
                findFishs.sort(Comparator.naturalOrder());
                Node fish = findFishs.get(0);
                shark.eat(fish);
                board[fish.x][fish.y] = 0;
                return time;
            }
            time++;
        }
        return null;
    }

    private class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    private class Shark {
        int x;
        int y;
        int size;
        int count;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            size = 2;
            count = 0;
        }

        public void eat(Node fish) {
            this.x = fish.x;
            this.y = fish.y;
            if (count + 1 == size) {
                size++;
                count = 0;
            } else {
                count++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
