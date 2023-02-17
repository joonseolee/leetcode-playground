class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        for (int num : nums) {
            queue.add(num);
        }
        
        while (!queue.isEmpty()) {
            int value = queue.poll();
            if (k == 1) {
                return value;
            }
            
            k--;
        }
        
        return -1;
    }
}