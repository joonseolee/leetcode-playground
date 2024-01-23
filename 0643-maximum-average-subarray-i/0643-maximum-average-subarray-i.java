class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int start = 0;
        int end = k - 1;
        int sum = 0;
        int current = 0;
        for (int i = start; i < k; i++) {
            sum += nums[i];
        }
        
        current = sum;
        start++;
        end++;
        
        while (end < nums.length) {
            current = requireSum(nums, start, end, current);
            if (sum < current) {
                sum = current;
            }
            
            start++;
            end++;
        }
        
        return (double) sum / k;
    }
    
    private int requireSum(int[] nums, int start, int end, int sum) {
        return sum - nums[start - 1] + nums[end];
    }
}