class Solution {
    public int minimumDeleteSum(String aText, String bText) {
        int aTextLength = aText.length();
        int bTextLength = bText.length();
        int[][] dp = new int[aTextLength + 1][bTextLength + 1];

        for (int i = 1; i <= aTextLength; i++) {
            dp[i][0] = dp[i - 1][0] + aText.charAt(i - 1);
        }

        for (int j = 1; j <= bTextLength; j++) {
            dp[0][j] = dp[0][j - 1] + bText.charAt(j - 1);
        }

        for (int i = 1; i <= aTextLength; i++) {
            for (int j = 1; j <= bTextLength; j++) {
                if (aText.charAt(i - 1) == bText.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            dp[i - 1][j] + aText.charAt(i - 1),
                            dp[i][j - 1] + bText.charAt(j - 1));
                }
            }
        }

        return dp[aTextLength][bTextLength];
    }
}