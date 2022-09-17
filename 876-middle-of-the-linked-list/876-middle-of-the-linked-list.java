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
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode node = head;
        
        while (node.next != null) {
            count++;
            node = node.next;
        }
        count++;
        
        int middleIndex = count / 2 + 1;
        
        count = 1;
        node = head;
        while (node.next != null) {
            if (count == middleIndex) {
                return node;
            }
            
            count++;
            node = node.next;
        }
        
        return count == 1 ? head : head.next;
    }
}