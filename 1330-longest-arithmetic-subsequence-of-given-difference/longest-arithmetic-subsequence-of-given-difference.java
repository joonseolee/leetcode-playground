class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int result = 0;
        
        for (int num : arr) {
            // 현재 num을 이어 붙일 수 있는 subsequence의 길이를 계산
            int count = dp.getOrDefault(num - difference, 0) + 1;
            dp.put(num, count);
            result = Math.max(result, count);
        }
        
        return result;
    }
}