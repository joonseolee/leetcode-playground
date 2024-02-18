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
    public ListNode deleteMiddle(ListNode head) {
        ListNode node = head;
        int length = 1;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        
        int targetIndex = length / 2;
        int currentIndex = 0;
        node = head;
        ListNode prev = null;
        while (targetIndex != currentIndex) {
            prev = node;
            node = node.next;
            currentIndex++;
        }
        
        if (node.next == null) {
            if (prev == null) {
                return null;
            }
            prev.next = null;
        } else {
            prev.next = node.next;
        }
        
        return head;
    }
}