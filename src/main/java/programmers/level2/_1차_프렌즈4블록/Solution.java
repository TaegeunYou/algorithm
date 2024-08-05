package main.java.programmers.level2._1차_프렌즈4블록;

import java.util.ArrayList;

class Solution {

    int answer = 0;
    Character[][] arr;
    public int solution(int m, int n, String[] board) {
        arr = new Character[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            ArrayList<Node> nodes = new ArrayList<>();
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char tmp = arr[i][j];
                    if (tmp != 0 && arr[i][j + 1] == tmp && arr[i + 1][j] == tmp && arr[i + 1][j + 1] == tmp) {
                        nodes.add(new Node(i, j));
                    }
                }
            }
            if (nodes.isEmpty()) break;
            for (Node node : nodes) {
                remove(node.x, node.y);
                remove(node.x, node.y + 1);
                remove(node.x + 1, node.y);
                remove(node.x + 1, node.y + 1);
            }
            formatting(m, n);
        }
        return answer;
    }

    private void remove(int x, int y) {
        if (arr[x][y] != 0) {
            arr[x][y] = 0;
            answer++;
        }
    }

    private void formatting(int m, int n) {
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    for (int k = i - 1; k >= 0; k--) {
                        if (arr[k][j] != 0) {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}