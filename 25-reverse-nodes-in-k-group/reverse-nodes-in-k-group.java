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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // groupPrev: 뒤집을 그룹의 '직전' 노드
        ListNode groupPrev = dummy;

        while (true) {
            // 1. 현재 위치에서 k번째 노드가 존재하는지 확인 (k만큼 전진)
            ListNode kth = groupPrev;
            for (int i = 0; i < k && kth != null; i++) {
                kth = kth.next;
            }

            // k번째 노드가 없으면(null), 남은 노드가 k개 미만이라는 뜻 -> 그대로 두고 종료
            if (kth == null) break;

            // 2. 그룹의 범위 설정
            ListNode groupStart = groupPrev.next; // 현재 그룹의 첫 노드
            ListNode groupNext = kth.next;        // 다음 그룹의 첫 노드 (임시 저장)

            // 3. 연결 끊기 (독립된 리스트로 만듦 - 뒤집기 쉽게)
            kth.next = null; 

            // 4. 그룹 뒤집기 (helper 함수 없이 인라인 처리도 가능하지만, 가독성 위해 로직 수행)
            // 반환값은 뒤집힌 그룹의 새로운 시작(원래는 k번째였던 노드)
            reverseList(groupStart);

            // 5. 다시 연결하기
            groupPrev.next = kth;       // 앞부분 연결: 이전 그룹 -> (뒤집힌) 현재 그룹 시작
            groupStart.next = groupNext; // 뒷부분 연결: (뒤집힌) 현재 그룹 끝 -> 다음 그룹 시작

            // 6. 포인터 이동
            groupPrev = groupStart; // 방금 처리한 그룹의 마지막이 다음 그룹의 prev가 됨
        }

        return dummy.next;
    }

    // 표준적인 뒤집기 로직 (공간 O(1))
    private void reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}