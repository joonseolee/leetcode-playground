class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0, 0);
    }

    private int find(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }

            return 0;
        }

        int a = find(nums, target, index + 1, sum + nums[index]);
        int b = find(nums, target, index + 1, sum - nums[index]);

        return a + b;
    }
}