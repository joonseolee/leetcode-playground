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
        return recursive(root, "");
    }
    
    private int recursive(TreeNode root, String sum) {
        if (root == null) {
            return Integer.parseInt(sum);
        }
        
        if (root.left == null && root.right == null) {
            return Integer.parseInt(sum + String.valueOf(root.val));
        }
        
        sum += String.valueOf(root.val);
        
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