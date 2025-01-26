class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 || n == 1) {
            return matrix[0][0];
        }

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < m; ++i) {
            ans = Math.min(ans, minFallingPathSum(matrix, 0, i, dp));
        }

        return ans;
    }

    private int minFallingPathSum(int[][] A, int row, int col, int[][] dp) {
        int m = A.length;
        int n = A[0].length;

        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        if (row == m - 1) {
            return dp[row][col] = A[row][col];
        }

        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;

        if (col > 0) {
            left = minFallingPathSum(A, row + 1, col - 1, dp);
        }

        int straight = minFallingPathSum(A, row + 1, col, dp);

        if (col < n - 1) {
            right = minFallingPathSum(A, row + 1, col + 1, dp);
        }

        return dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];
    }
}