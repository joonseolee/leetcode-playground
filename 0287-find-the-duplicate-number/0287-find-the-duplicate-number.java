class Solution {
    public int findDuplicate(int[] nums) {
        // 100000
        boolean[] visit = new boolean[100001];
        for (int num : nums) {
            if (visit[num]) {
                return num;
            }
            
            visit[num] = true;
        }
        
        return -1;
    }
}