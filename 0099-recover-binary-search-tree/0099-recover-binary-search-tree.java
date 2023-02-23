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
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;
    
    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        if (prev != null && root.val < prev.val) {
            if(first == null) {
                first = prev;
            }
            
            second = root;
        }
        
        prev = root;
        inOrder(root.right);
    }
    
    public void recoverTree(TreeNode root) {
        inOrder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}