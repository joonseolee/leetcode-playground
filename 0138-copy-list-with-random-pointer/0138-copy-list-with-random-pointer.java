/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

import java.util.*;

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node root = new Node(head.val);
        Map<Node, Node> map = new HashMap<>();
        map.put(head, root);
        generate(root, head.next, head.random, map);
        return root;
    }
    
    public void generate(Node root, Node next, Node random, Map<Node, Node> map) {
        if (root == null) {
            return;
        }
        
        if (next != null) {
            root.next = map.getOrDefault(next, new Node(next.val));
            map.put(next, root.next);
            generate(root.next, next.next, next.random, map);
        }
        
        if (random != null) {
            root.random = map.getOrDefault(random, new Node(random.val));
            map.put(random, root.random);
        }
    }
}