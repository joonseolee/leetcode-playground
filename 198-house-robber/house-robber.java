class Solution {

    // tabulation
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        solution(2, nums, dp);

        return Arrays.stream(dp).max().getAsInt();
    }

    private void solution(int current, int[] nums, int[] dp) {
        if (current >= nums.length) {
            return;
        }

        int maxValue = Math.max(dp[current - 2] + dp[current], dp[current - 1]);
        if (current - 3 > -1) {
            maxValue = Math.max(maxValue, dp[current] + dp[current - 3]);
        }

        dp[current] = maxValue;
        solution(current + 1, nums, dp);
    }
}