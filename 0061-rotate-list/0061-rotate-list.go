/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
    if k == 0 || head == nil {
        return head
    }
    
    count := 1
    temp := head
    for temp.Next != nil {
        count++
        temp = temp.Next
    }
    
    if k > count {
        k = k % count
    }
    
    if k == count {
        return head
    }
    
    k = count - k - 1
    temp.Next = head
    temp = head
    for k > 0 {
        k--;
        temp = temp.Next
    }
    
    head = temp.Next
    temp.Next = nil
    return head
}