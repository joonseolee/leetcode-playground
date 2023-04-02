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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursive(root, list, 0);
        return list;
    }
    
    private void recursive(TreeNode root, List<Integer> list, int depth) {
        if (root == null) {
            return;
        }
        
        if (depth == list.size()) {
            list.add(root.val);
        }
        
        recursive(root.right, list, depth + 1);
        recursive(root.left, list, depth + 1);
    }
}