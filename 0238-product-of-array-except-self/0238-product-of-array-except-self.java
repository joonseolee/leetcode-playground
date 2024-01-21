class Solution {
    public int[] productExceptSelf(int[] nums) {
        int value = 1;
        for (int num : nums) {
            value *= num;
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = requireValueExcept(nums, i);
                continue;
            }
            
            result[i] = value / nums[i];
        }
        
        return result;
    }
    
    private int requireValueExcept(int[] nums, int i) {
        int value = 1;
        for (int k = 0; k < nums.length; k++) {
            if (k != i) {
                value *= nums[k];
            }
        }
        
        return value;
    }
}