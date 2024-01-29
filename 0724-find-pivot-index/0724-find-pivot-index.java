class Solution {
    public int pivotIndex(int[] nums) {
        int total = 0;
        int leftsum = 0;

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < nums.length; leftsum += nums[i++]) {
            if (leftsum * 2 == total - nums[i]) {
                return i;
            }
        }

        return -1;
    }
}