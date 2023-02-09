class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int triangleSize = triangle.size();
        int dp [] [] = new int [triangleSize][triangleSize];
        for (int i = 0; i< triangleSize; i++) {
            dp[triangleSize - 1][i] = triangle.get(triangleSize - 1).get(i);
        }
        
        for (int i = triangleSize- 2; i>=0; i--) {
            for(int j = i; j >= 0; j--){
                int up = dp[i + 1][j] + triangle.get(i).get(j);
                int upleft = dp[i + 1][j + 1] + triangle.get(i).get(j);
                dp[i][j] = Math.min(up, upleft);
            }
        }
        
        return dp[0][0];
    }
}