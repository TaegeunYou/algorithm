package main.java.programmers.level3.카드_짝_맞추기;

import java.util.*;

class Solution {

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int boardLength = 4;

    List<Card> cards;
    int[][] board;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] board, int r, int c) {
        this.board = board;
        this.cards = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    cards.add(new Card(i, j, board[i][j]));
                }
            }
        }
        int cardCount = cards.size();
        for (int i = 0; i < cardCount; i++) {
            Card card = cards.get(i);
        }
        findAny(r, c, 0);
        //주변에 아무 카드 찾아가기 함수 : dfs
        //특정 카드를 찾아가기 함수 : bfs 하다가 return
        return answer;
    }

    private void findAny(int x, int y, int total) {
        if (cards.isEmpty()) {
            answer = Math.min(answer, total);
            return;
        }
        for (int i = 0; i < cards.size(); i++) {
            int count = 0;
            Card card = cards.get(i);
            count += findShortestPath(x, y, card.x, card.y); //1번 카드로 가기
            count++; //엔터
            int cardIdx = cards.indexOf(card);
            cards.remove(card);
            board[card.x][card.y] = 0;
            Card cardPair = findPair(card.num);
            count += findShortestPath(card.x, card.y, cardPair.x, cardPair.y); //2번 카드로 가기
            count++; //엔터
            int cardPairIdx = cards.indexOf(cardPair);
            cards.remove(cardPair);
            board[cardPair.x][cardPair.y] = 0;

            //dfs
            findAny(cardPair.x, cardPair.y, total + count);

            //복구
            cards.add(cardPairIdx, cardPair);
            board[cardPair.x][cardPair.y] = cardPair.num;
            cards.add(cardIdx, card);
            board[card.x][card.y] = card.num;
        }
    }

    private int findShortestPath(int startX, int startY, int endX, int endY) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.offerLast(new Node(startX, startY));
        int count = 0;
        boolean[][] visited = new boolean[boardLength][boardLength];
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.pollFirst();
                if (node.x == endX && node.y == endY) {
                    return count;
                }
                if (visited[node.x][node.y]) {
                    continue;
                }
                visited[node.x][node.y] = true;
                //방향키
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x + dx[j];
                    int ny = node.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= boardLength || ny >= boardLength || visited[nx][ny]) {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny));
                }
                //Ctrl + 방향키
                //해당 방향으로 카드가 있으면 있는 가장 가까운 카드
                //해당 방향으로 카드가 없으면 가장 마지막 칸
                for (int j = 0; j < dx.length; j++) {
                    int nx = node.x;
                    int ny = node.y;
                    while (true) {
                        int nextX = nx + dx[j];
                        int nextY = ny + dy[j];
                        if (nextX < 0 || nextY < 0 || nextX >= boardLength || nextY >= boardLength) {
                            break;
                        }
                        nx = nextX;
                        ny = nextY;
                        if (board[nx][ny] != 0) {
                            break;
                        }
                    }
                    if (visited[nx][ny] || (nx == node.x && ny == node.y)) {
                        continue;
                    }
                    queue.offerLast(new Node(nx, ny));
                }
            }
            count++;
        }
        return -1;
    }

    private Card findPair(int num) {
        for (Card card : cards) {
            if (card.num == num) {
                return card;
            }
        }
        return null;
    }

    private class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Card {
        int x;
        int y;
        int num;

        public Card(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }
}
