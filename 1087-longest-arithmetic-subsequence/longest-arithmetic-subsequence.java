class Solution {
    public int longestArithSeqLength(int[] nums) {
        int result = 2;
        Map<Integer, Integer>[] dp = new HashMap[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int count = dp[j].getOrDefault(diff, 1) + 1;
                dp[i].put(diff, count);
                result = Math.max(result, count);
            }
        }

        return result;
    }
}