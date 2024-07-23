package main.java.inflearn.DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 0 0 0 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 0 0 0
 */
class Main0811 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int answer = -1;
        int[][] maze = new int[8][8];
        int[][] dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                maze[i][j] = in.nextInt();
            }
        }
        Queue<Node> queue = new LinkedList<>();
        maze[1][1] = 1;
        dis[1][1] = 0;
        queue.offer(new Node(1, 1));
        while (!queue.isEmpty() && answer == -1) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (node.x == 7 && node.y == 7) {
                    answer = dis[node.x][node.y];
                    break;
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && maze[nx][ny] == 0) {
                        maze[nx][ny] = 1;
                        dis[nx][ny] = dis[node.x][node.y] + 1;
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}