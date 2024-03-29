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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return Math.max(solution(root.left, 1), solution(root.right, 1));
    }
    
    private int solution(TreeNode node, int count) {
        if (node == null) {
            return count;
        }
        
        return Math.max(solution(node.left, count + 1), solution(node.right, count + 1));
    }
}