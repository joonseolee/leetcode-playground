/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        
        for (ListNode node : lists) {
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }
        }
        
        ListNode current = null;
        while (!queue.isEmpty()) {
            int value = queue.poll();
            current = new ListNode(value, current);
        }
        
        return current;
    }
}