class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int result = 0;
        
        for (int n : gain) {
            current += n;
            result = Math.max(current, result);
        }
        
        return result;
    }
}