class Solution {
    public int climbStairs(int n) {
        int x = 0;
        int y = 1;
        int sum = 0;
        
        for (int i = 0 ; i < n ; i++) {
            sum = x + y;
            x = y;
            y = sum;
        }
        
        return sum;
    }
}