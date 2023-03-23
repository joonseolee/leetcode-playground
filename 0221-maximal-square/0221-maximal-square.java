class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int max = 0;
        int maxHeight = matrix.length;
        int minHeight = matrix[0].length;
        int[][] dp = new int[maxHeight + 1][minHeight + 1];

        for (int i = 1; i <= maxHeight; i++) {
            for (int j = 1; j <= minHeight; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;
    }
}