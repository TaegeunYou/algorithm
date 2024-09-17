package main.java.programmers.level2.택배_배달과_수거하기;

import java.util.ArrayDeque;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        ArrayDeque<Integer> deliveriesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> pickupsQueue = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < deliveries[i]; j++) {
                deliveriesQueue.offerLast(i + 1);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < pickups[i]; j++) {
                pickupsQueue.offerLast(i + 1);
            }
        }
        while (!deliveriesQueue.isEmpty() || !pickupsQueue.isEmpty()) {
            Integer tmpDeliverDistance = null;
            Integer tmpPickupDistance = null;

            int deliverCap = Math.min(cap, deliveriesQueue.size());
            while (deliverCap != 0 && !deliveriesQueue.isEmpty()) {
                Integer poll = deliveriesQueue.pollFirst();
                if (tmpDeliverDistance == null) tmpDeliverDistance = poll;
                deliverCap--;
            }

            int pickupCap = 0;
            while (pickupCap < cap && !pickupsQueue.isEmpty()) {
                Integer poll = pickupsQueue.pollFirst();
                if (tmpPickupDistance == null) tmpPickupDistance = poll;
                pickupCap++;
            }

            long distance = Math.max(
                tmpDeliverDistance == null ? 0 : tmpDeliverDistance,
                tmpPickupDistance == null ? 0 : tmpPickupDistance
            );
            answer += (distance * 2);
        }
        return answer;
    }
}