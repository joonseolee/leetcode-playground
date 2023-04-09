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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        if (head.next == null || k == 0) {
            return head;
        }
        
        int size = 1;
        ListNode root = head;
        while (root.next != null) {
            root = root.next;
            size++;
        }
        
        int startPoint = getStartPoint(size, k);
        System.out.println(startPoint);
        if (startPoint == 0) {
            return head;
        }

        root = head;
        while (startPoint > 1) {
            root = root.next;
            startPoint--;
        }
        
        ListNode result = root.next;
        ListNode target = root.next;
        root.next = null;
        while (target.next != null) {
            target = target.next;
        }
        
        target.next = head;
        return result;
    }
    
    private int getStartPoint(int size, int k) {
        if (size == k) {
            return 0;
        }
        
        if (size > k) {
            return size - k;
        }
        
        int rest = k % size;
        if (rest == 0) {
            return 0;
        }
        
        return size - rest;
    }
}