/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        Queue<Packet> queue = new LinkedList<>();
        queue.add(new Packet(root, root.val));
        
        while (!queue.isEmpty()) {
            Packet packet = queue.poll();
            if (packet.root.left == null && packet.root.right == null && packet.sum == targetSum) {
                return true;
            }
            
            if (packet.root.left != null) {
                queue.add(new Packet(packet.root.left, packet.sum + packet.root.left.val));
            }
            
            if (packet.root.right != null) {
                queue.add(new Packet(packet.root.right, packet.sum + packet.root.right.val));
            }
        }
        
        return false;
    }
    
    public class Packet {
        TreeNode root;
        int sum;
        
        Packet(TreeNode root, int sum) { this.root = root; this.sum = sum; }
    }
}