class Solution {
    public int search(int[] nums, int target) {
        int firstIndex = 0;
        int lastIndex = nums.length - 1;
        
        while (firstIndex <= lastIndex) {
            int pivot = (lastIndex + firstIndex) / 2;
            
            if (nums[pivot] == target) {
                return pivot;
            }
            
            if (nums[pivot] > target) {
                lastIndex = pivot - 1;
            } else {
                firstIndex = pivot + 1;
            }
        }
        
        return -1;
    }
}