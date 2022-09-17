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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode node = head;
        while (node.next != null) {
            nodes.add(node);
            node = node.next;
        }
        nodes.add(node);
        
        int targetIndex = nodes.size() - n;
        if (targetIndex == 0) {
            return head.next;
        }
        for (int i = 0 ; i < nodes.size() ; i++) {
            if (i == nodes.size() - 1) {
                ListNode beforeNode = nodes.get(i - 1);
                beforeNode.next = null;
                nodes.set(i, null);
                break;
            }
            if (targetIndex == i) {
                ListNode beforeNode = nodes.get(i - 1);
                ListNode nextNode = nodes.get(i + 1);
                beforeNode.next = nextNode;
                nodes.set(i, null);
                break;
            }
        }
        
        return nodes.get(0);
    }
}