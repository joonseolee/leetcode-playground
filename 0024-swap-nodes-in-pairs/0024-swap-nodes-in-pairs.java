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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        
        ListNode result = head;
        ListNode next = head.next;
        while(next != null) {
            int temp = head.val;
            head.val = next.val;
            next.val = temp;
            
            head = next.next;
            next = head == null ? null : head.next;
        }
        
        return result;
    }
}