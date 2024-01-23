class Solution {
    public int maxOperations(int[] nums, int k) {
        int[] sortedNums = Arrays.stream(nums).sorted().toArray();
        int start = 0;
        int end = nums.length - 1;
        
        int result = 0;
        while (start < end) {
            int sum = sortedNums[start] + sortedNums[end];
            if (sum == k) {
                result++;
                start++;
                end--;
                continue;
            }
            
            if (sum > k) {
                end--;
                continue;
            }
            
            start++;
        }
        
        return result;
    }
}