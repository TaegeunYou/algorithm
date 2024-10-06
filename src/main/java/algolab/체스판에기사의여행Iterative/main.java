package main.java.algolab.체스판에기사의여행Iterative;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class main {

    private static final int MAX_SIZE = 9;
    private static final int MARKED = 1;
    private static final int UNMARKED = 0;

    private static final int[][] DIRECTIONS = {
        {1, -2}, {2, -1}, {2, 1}, {1, 2},
        {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}
    };

    private static int[][] board = new int[MAX_SIZE][MAX_SIZE];
    private static int[][] movePath = new int[MAX_SIZE][MAX_SIZE];
    private static Stack<Position> visitedPositions = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (testCases > 0) {
            testCases--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int rows = Integer.parseInt(st.nextToken());
            int cols = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            Position startPosition = new Position(startY, startX, 1, 0);
            visitedPositions.push(startPosition);

            for (int row = 1; row <= rows; row++) {
                for (int col = 1; col <= cols; col++) {
                    board[row][col] = UNMARKED;
                }
            }

            board[startPosition.y][startPosition.x] = MARKED;
            movePath[startPosition.y][startPosition.x] = 1;

            if (performKnightTour(rows, cols)) {
                sb.append(1).append("\n");
                for (int row = 1; row <= rows; row++) {
                    for (int col = 1; col <= cols; col++) {
                        sb.append(movePath[row][col]).append(" ");
                    }
                    sb.append("\n");
                }
            } else {
                sb.append("0").append("\n");
            }

            visitedPositions.clear();
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static boolean performKnightTour(int rows, int cols) {
        boolean hasNextMove;
        Position currentPosition, nextPosition;

        while (!visitedPositions.isEmpty() && visitedPositions.peek().moveCount < rows * cols) {
            hasNextMove = false;
            currentPosition = visitedPositions.peek();

            for (int i = currentPosition.directionIndex; i < 8; i++) {
                int nextX = currentPosition.x + DIRECTIONS[i][0];
                int nextY = currentPosition.y + DIRECTIONS[i][1];
                currentPosition.directionIndex++;

                if (nextX > 0 && nextX <= cols && nextY > 0 && nextY <= rows && board[nextY][nextX] != MARKED) {
                    nextPosition = new Position(nextX, nextY, currentPosition.moveCount + 1, 0);
                    board[nextY][nextX] = MARKED;
                    movePath[nextY][nextX] = nextPosition.moveCount;
                    visitedPositions.push(nextPosition);
                    hasNextMove = true;
                    break;
                }
            }

            if (hasNextMove) {
                continue;
            }

            visitedPositions.pop();
            board[currentPosition.y][currentPosition.x] = UNMARKED;
        }

        return !visitedPositions.isEmpty() && visitedPositions.peek().moveCount == rows * cols;
    }

    private static class Position {
        int x, y, moveCount, directionIndex;

        Position(int x, int y, int moveCount, int directionIndex) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
            this.directionIndex = directionIndex;
        }
    }

}