package main.java.programmers.level3.다단계_칫솔_판매;

import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> parentMap = new HashMap<>();
        HashMap<String, Integer> amountMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            parentMap.put(enroll[i], referral[i]);
            amountMap.put(enroll[i], 0);
        }
        for (int i = 0; i < seller.length; i++) {
            String sellerName = seller[i];
            int sellAmount = amount[i] * 100;
            while (!sellerName.equals("-") && sellAmount >= 1) {
                int sellerGiveAmount = (int) (sellAmount * 0.1);
                int sellerGetAmount = sellerGiveAmount < 1 ? sellAmount : sellAmount - sellerGiveAmount;
                amountMap.put(sellerName, amountMap.get(sellerName) + sellerGetAmount);
                sellerName = parentMap.get(sellerName);
                sellAmount = sellerGiveAmount;
            }
        }
        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = amountMap.get(enroll[i]);
        }
        return answer;
    }

}