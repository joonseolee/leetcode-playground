class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();
        
        for (int num : nums) {
            int pos = Collections.binarySearch(sub, num);
            
            if (pos < 0) {
                pos = -(pos + 1);
            }
            
            if (pos < sub.size()) {
                sub.set(pos, num);
            } else {
                sub.add(num);
            }
        }
        
        return sub.size();
    }
}