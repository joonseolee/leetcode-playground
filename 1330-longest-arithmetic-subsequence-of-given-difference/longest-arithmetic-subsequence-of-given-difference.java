class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> dp = new HashMap<>();
        int result = 0;
        
        for (int num : arr) {
            int count = dp.getOrDefault(num - difference, 0) + 1;
            dp.put(num, count);
            result = Math.max(result, count);
        }
        
        return result;
    }
}