import java.util.*;

class Solution {
    public class Node {
        int value;
        Node next;
        Node prev;

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrev() {
            return prev != null;
        }

        public Node(int value) {
            this.value = value;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        Node base = new Node(0);
        Node current = base;

        // 연결 리스트 초기화
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            node.prev = current;
            current.next = node;
            current = node;
        }

        // k 위치로 이동
        current = base;
        for (int i = 0; i < k; i++) {
            current = current.next;
        }

        Stack<Node> deleteStack = new Stack<>(); // 삭제된 노드를 저장

        for (String command : cmd) {
            char type = command.charAt(0);

            if (type == 'U') {
                int move = Integer.parseInt(command.split(" ")[1]);
                while (move-- > 0 && current.hasPrev()) {
                    current = current.prev;
                }
                continue;
            }

            if (type == 'D') {
                int move = Integer.parseInt(command.split(" ")[1]);
                while (move-- > 0 && current.hasNext()) {
                    current = current.next;
                }
                continue;
            }

            if (type == 'C') {
                deleteStack.push(current); // 삭제된 노드 자체를 저장

                if (!current.hasPrev()) { // 맨 앞 노드 삭제
                    current = current.next;
                    current.prev = null;
                } else if (!current.hasNext()) { // 맨 뒤 노드 삭제
                    current = current.prev;
                    current.next = null;
                } else { // 중간 노드 삭제
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current = current.next;
                }
                continue;
            }

            if (type == 'Z') {
                Node restored = deleteStack.pop(); // 삭제된 노드 복구

                if (restored.prev != null) {
                    restored.prev.next = restored;
                }
                if (restored.next != null) {
                    restored.next.prev = restored;
                }
            }
        }

        // 결과 문자열 생성
        StringBuilder result = new StringBuilder("O".repeat(n));
        for (Node node : deleteStack) {
            result.setCharAt(node.value, 'X');
        }

        return result.toString();
    }
}