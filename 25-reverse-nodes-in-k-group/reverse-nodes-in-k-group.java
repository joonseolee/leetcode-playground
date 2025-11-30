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
        // 예외 처리: 리스트가 비었거나, k가 1이면 뒤집을 필요 없음
        if (head == null || k == 1) return head;

        // 1. 더미 노드 생성 (헤드가 바뀌는 경우를 대비해 맨 앞에 가짜 노드를 둡니다)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. 전체 리스트 길이 계산
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        // 3. 그룹별로 뒤집기 시작
        ListNode pre = dummy;   // 뒤집을 그룹의 '직전' 노드
        ListNode curr = null;   // 현재 처리 중인 노드
        ListNode nex = null;    // 앞으로 당겨올 노드

        // 남은 노드 개수가 k개 이상일 때만 뒤집기 수행
        while (count >= k) {
            curr = pre.next; // 현재 그룹의 첫 번째 노드 (나중엔 그룹의 맨 뒤로 감)
            nex = curr.next; // 현재 그룹의 두 번째 노드 (앞으로 당겨올 녀석)

            // k개의 노드를 뒤집으려면 링크 조작은 k-1번 일어납니다.
            // 예: 1->2->3을 뒤집으려면, 2를 1 앞으로, 3을 2 앞으로 (총 2번 이동)
            for (int i = 0; i < k - 1; i++) {
                // 이 부분이 핵심! (Pointer Rewiring)
                curr.next = nex.next;  // 1. curr가 nex의 다음 노드를 가리키게 함
                nex.next = pre.next;   // 2. nex가 현재 그룹의 맨 앞을 가리키게 함
                pre.next = nex;        // 3. pre가 nex를 가리키게 함 (nex가 맨 앞으로 이동 완료)
                nex = curr.next;       // 4. 다음 루프를 위해 nex 재설정
            }
            
            // 한 그룹이 끝났으니 pre 포인터를 이번 그룹의 마지막 노드(curr)로 이동
            pre = curr;
            count -= k; // 처리한 k개만큼 전체 개수에서 차감
        }

        return dummy.next;
    }
}