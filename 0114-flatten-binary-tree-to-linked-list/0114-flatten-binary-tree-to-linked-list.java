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
    public void flatten(TreeNode root) {
        dfs(root);
    }
    
    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode leftNode = dfs(root.left);
        TreeNode rightNode = dfs(root.right);

        root.left = null;
        if (leftNode != null) {
            root.right = leftNode;
        }

        if (leftNode != null) {
            while (leftNode.right != null) {
                leftNode = leftNode.right;
            }
            leftNode.right = rightNode;
        }

        return root;
    }
}