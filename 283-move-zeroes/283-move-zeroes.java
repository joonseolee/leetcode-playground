class Solution {
    public void moveZeroes(int[] nums) {
        int first = 0;
        int last = nums.length - 1;
        
        while (first < last) {
            if (nums[first] != 0) {
                first++;
                continue;
            }
            
            moveLeftAllOfElements(nums, first, last);
            last--;
        }
    }
    
    private void moveLeftAllOfElements(int[] nums, int first, int last) {
        for (int i = first ; i < last ; i++) {
            nums[i] = nums[i + 1];
        }
        
        nums[last] = 0;
    }
}