class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int value = map.getOrDefault(num, -1);
            if (value != -1) {
                return true;
            }
            
            map.put(num, 1);
        }
        
        return false;
    }
}