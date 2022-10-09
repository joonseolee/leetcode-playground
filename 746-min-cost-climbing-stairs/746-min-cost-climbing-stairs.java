class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int x = cost[0];
        int y = cost[1];
        
        for (int i = 2 ; i < cost.length ; i++) {
            int temp = y;
            y = cost[i] + Math.min(x, y);
            x = temp;
        }
        
        return Math.min(x, y);
    }
}