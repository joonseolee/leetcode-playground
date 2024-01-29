class Solution {
    public int longestSubarray(int[] nums) {
        boolean isDeleted = false;
        int beforeZero = 0;
        int result = 0;
        int current = 0;

        for (int num : nums) {
            if (num == 1) {
                current++;
                result = Math.max(result, current);
            } else {
                if (!isDeleted) {
                    isDeleted = true;
                    beforeZero = current;
                } else {
                    current = current - beforeZero;
                    beforeZero = current;
                }
            }
        }

        if (!isDeleted) {
            return result - 1;
        }
        
        return result > 0 ? result : 0;
    }
}