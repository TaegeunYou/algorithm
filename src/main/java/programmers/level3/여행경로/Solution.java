package main.java.programmers.level3.여행경로;

import java.util.*;

class Solution {
    HashMap<String, PriorityQueue<Ticket>> map = new HashMap<>();
    String[][] tickets;
    ArrayDeque<String> stack = new ArrayDeque<>();
    ArrayList<String> answerList = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        for (String[] ticket : tickets) {
            String origin = ticket[0];
            String dest = ticket[1];
            PriorityQueue<Ticket> dests = map.getOrDefault(origin, new PriorityQueue<>());
            dests.offer(new Ticket(dest));
            map.put(origin, dests);
        }
        String firstOrigin = "ICN";
        stack.offerLast(firstOrigin);
        dfs(0, firstOrigin);
        Collections.sort(answerList);
        return answerList.get(0).split(" ");
    }

    private void dfs(int idx, String origin) {
        if (idx == tickets.length) {
            String str = "";
            for (String s : stack) {
                str += (s + " ");
            }
            answerList.add(str);
            return;
        }
        PriorityQueue<Ticket> dests = map.get(origin);
        if (dests != null) {
            for (Ticket ticket : dests) {
                if (!ticket.isUsed) {
                    stack.offerLast(ticket.dest);
                    ticket.isUsed = true;
                    dfs(idx + 1, ticket.dest);
                    ticket.isUsed = false;
                    stack.pollLast();
                }
            }
        }
    }

    class Ticket implements Comparable<Ticket>{
        String dest;
        Boolean isUsed;

        public Ticket(String dest) {
            this.dest = dest;
            this.isUsed = false;
        }

        @Override
        public int compareTo(Ticket ticket) {
            return this.dest.compareTo(ticket.dest);
        }
    }

}