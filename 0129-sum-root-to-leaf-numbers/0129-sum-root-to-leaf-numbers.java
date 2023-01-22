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
    public int sumNumbers(TreeNode root) {
        return recursive(root, 0);
    }
    
    private int recursive(TreeNode root, int sum) {
        if (root == null) {
            return sum;
        }
        
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }
        
        sum = sum * 10 + root.val;
        
        int left = 0;
        if (root.left != null) {
            left = recursive(root.left, sum);
        }
        int right = 0;
        if (root.right != null) {
            right = recursive(root.right, sum);
        }
        
        return left + right;
    }
}