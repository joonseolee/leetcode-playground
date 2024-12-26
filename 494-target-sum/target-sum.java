class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // target이 유효한 범위 내에 있는지 확인
        if (target > sum || target < -sum) {
            return 0;
        }

        int offset = sum;  // 음수 인덱스를 피하기 위해 전체 배열을 shift
        int[] dp = new int[2 * sum + 1];
        dp[offset] = 1; // sum이 0일 때 1가지 방법 (빈 집합)

        for (int num : nums) {
            int[] next = new int[2 * sum + 1]; // 새 배열을 준비하여 이전 배열을 갱신
            for (int s = -sum; s <= sum; s++) {
                if (dp[s + offset] > 0) {
                    next[s + num + offset] += dp[s + offset];  // 더하는 경우
                    next[s - num + offset] += dp[s + offset];  // 빼는 경우
                }
            }
            dp = next;  // dp 배열을 갱신
        }

        return dp[target + offset];
    }
}