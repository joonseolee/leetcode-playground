class Solution {
    public int searchInsert(int[] nums, int target) {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;
        
        while (firstIndex <= lastIndex) {
            int pivot = (firstIndex + lastIndex) / 2;
            
            if (nums[pivot] == target) {
                return pivot;
            }
            
            if (nums[pivot] > target) {
                lastIndex = pivot - 1;
            } else {
                firstIndex = pivot + 1;
            }
        }
        
        if (lastIndex == -1) {
            return 0;
        }
        
        if (firstIndex > nums.length - 1) {
            return nums.length;
        }
        
        return (firstIndex + lastIndex + 1) / 2;
    }
}