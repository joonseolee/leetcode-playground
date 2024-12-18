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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode result = head;
        ListNode appendNode = null;

        while (true) {
            if (head.next == null) {
                head.next = appendNode;
                break;
            }

            ListNode temp = head.next;
            if (appendNode == null) {
                appendNode = temp;
            } else {
                append(appendNode, temp);
            }

            head.next = head.next.next;
            temp.next = null;
            if (head.next == null) {
                head.next = appendNode;
                break;
            }
            head = head.next;

        }

        return result;
    }

    private void append(ListNode appendNode, ListNode temp) {
        ListNode appendTemp = appendNode;
        while (appendTemp != null) {
            if (appendTemp.next == null) {
                appendTemp.next = temp;
                return;
            }

            appendTemp = appendTemp.next;
        }
    }
}