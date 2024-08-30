package main.java.programmers.level3.베스트앨범;

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Genre> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String name = genres[i];
            int num = plays[i];
            Genre genre = map.getOrDefault(name, new Genre(name));
            genre.sum += num;
            if (genre.queue.size() < 2) {
                genre.queue.offer(new Node(num, i));
            } else if (genre.queue.peek().count < num) {
                genre.queue.poll();
                genre.queue.offer(new Node(num, i));
            }
            map.put(name, genre);
        }
        ArrayList<Genre> list = new ArrayList<>(map.values());
        Collections.sort(list);
        ArrayList<Integer> answer = new ArrayList<>();
        for (Genre genre : list) {
            if (genre.queue.size() == 1) {
                answer.add(genre.queue.poll().idx);
            } else {
                Node small = genre.queue.poll();
                Node big = genre.queue.poll();
                if (small.count == big.count) {
                    answer.add(Math.min(small.idx, big.idx));
                    answer.add(Math.max(small.idx, big.idx));
                } else {
                    answer.add(big.idx);
                    answer.add(small.idx);
                }
            }
        }
        return answer.stream().mapToInt(it -> it).toArray();
    }

    class Genre implements Comparable<Genre> {
        String genre;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int sum;

        public Genre(String genre) {
            this.genre = genre;
        }

        @Override
        public int compareTo(Genre o) {
            return o.sum - this.sum;
        }
    }

    class Node implements Comparable<Node> {
        int count;
        int idx;

        public Node(int count, int idx) {
            this.count = count;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }
}