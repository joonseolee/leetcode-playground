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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode current = null;

        while (list1 != null || list2 != null) {
            if (result == null) {
                if (list1 == null) {
                    return list2;
                }
                
                if (list2 == null) {
                    return list1;
                }
                
                if (list1.val > list2.val) {
                    result = list2;
                    current = list2;
                    list2 = list2.next;
                } else {
                    result = list1;
                    current = list1;
                    list1 = list1.next;
                }
                continue;
            }

            if (list1 == null) {
                current.next = list2;
                current = list2;
                list2 = list2.next;
                continue;
            }

            if (list2 == null) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
                continue;
            }

            if (list1.val > list2.val) {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            }
        }

        return result;
    }
}