class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int value = acquire(prices, i);
            answer[i] = value;
        }

        return answer;
    }

    private int acquire(int[] prices, int i) {
        int value = -1;
        for (int k = i; k < prices.length; k++) {
            value++;
            if (prices[k] < prices[i]) {
                break;
            }
        }

        return value;
    }
}