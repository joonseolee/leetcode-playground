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
          1
        2.  3
      4. n n 5
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        recursive(result, root, 0);
        return result;
    }
    
    public void recursive(List<List<Integer>> result, TreeNode root, int level) {
        if(root == null) {
            return;
        }
            
        if(result.size() < level + 1) {
            result.add(new ArrayList<>());
        }

        result.get(level).add(root.val);
        recursive(result, root.left, level + 1);
        recursive(result, root.right, level + 1);
    }
}