package main.java.programmers.level2.이모티콘_할인행사;

class Solution {

    int[] discountType = {40, 30, 20, 10};
    Emoticion[] emoticionArr;
    int[][] users;
    int maxPlus = 0;
    int maxPlusPrice = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        emoticionArr = new Emoticion[emoticons.length];
        this.users = users;
        dfs(0, emoticons);
        return new int[]{maxPlus, maxPlusPrice};
    }

    private void dfs(int idx, int[] emoticons) {
        if (idx == emoticons.length) {
            execute();
            return;
        }
        for (int discount : discountType) {
            emoticionArr[idx] = new Emoticion(discount, emoticons[idx] * (100 - discount) / 100);
            dfs(idx + 1, emoticons);
        }
    }

    private void execute() {
        int plus = 0;
        int price = 0;
        for (int[] user : users) {
            int sum = 0;
            for (Emoticion emoticion : emoticionArr) {
                if (user[0] <= emoticion.discount) {
                    sum += emoticion.price;
                }
            }
            if (sum >= user[1]) plus++;
            else price += sum;
        }
        if (plus > maxPlus || (plus == maxPlus && price > maxPlusPrice)) {
            maxPlus = plus;
            maxPlusPrice = price;
        }
    }

    class Emoticion {
        int discount;
        int price;

        public Emoticion(int discount, int price) {
            this.discount = discount;
            this.price = price;
        }
    }
}