class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = result;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sum + nums[i]) {
                result = Math.max(result, nums[i]);
                sum = nums[i];
                continue;
            }

            sum += nums[i];
            result = Math.max(sum, result);
        }

        return result;
    }
}