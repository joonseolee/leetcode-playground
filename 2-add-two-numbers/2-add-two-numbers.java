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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> list = new ArrayList<>();
        int overValue = 0;
        while (true) {
            int value = l1.val + l2.val;
            if (value + overValue > 9) {
                list.add(new ListNode(value + overValue - 10));
                overValue = 1;
            } else {
                list.add(new ListNode(value + overValue));
                overValue = 0;
            }
            
            if (l1.next == null && l2.next == null) {
                break;
            }
            l1 = l1.next == null ? new ListNode(0) : l1.next;
            l2 = l2.next == null ? new ListNode(0) : l2.next;
        }
        
        if (overValue > 0) {
            list.add(new ListNode(overValue));
        }
        
        for (int i = 0 ; i < list.size() - 1 ; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }
}