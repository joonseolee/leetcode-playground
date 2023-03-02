/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        doLogic(root);
        
        return root;
    }
    
    private void doLogic(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while (!q.isEmpty()) {
            int n = q.size();
            
            Node prev = null;
            for (int i = 1; i <= n; i++) {
                Node rem = q.poll();
                
                if (i != 1) {
                    prev.next = rem;
                }
                
                if (rem.left != null) {
                    q.add(rem.left);
                }
                
                if (rem.right!=null) {
                    q.add(rem.right);
                }
                
                prev = rem;
            }
        }
    }
}