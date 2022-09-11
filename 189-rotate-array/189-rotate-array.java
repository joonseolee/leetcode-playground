class Solution {
    public void rotate(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int num : nums) {
            deque.addLast(num);
        }
        
        while (k != 0) {
            deque.addFirst(deque.pollLast());
            k--;
        }

        for (int i = 0 ; i < nums.length ; i++) {
            nums[i] = deque.pollFirst();
        }
    }
}