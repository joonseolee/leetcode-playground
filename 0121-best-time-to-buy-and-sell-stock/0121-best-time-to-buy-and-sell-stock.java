class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        
        return getMax(prices, prices[0], 1);
    }
    
    private int getMax(int[] prices, int value, int start) {
        int result = 0;
        for (int i = start; i < prices.length; i++) {
            if (prices[i] < value) {
                value = prices[i];
                continue;
            }
            
            if (prices[i] < value) {
                result = Math.max(result, getMax(prices, prices[i], i + 1));
                continue;
            }
            
            result = Math.max(result, prices[i] - value);
        }
        
        return result;
    }
}