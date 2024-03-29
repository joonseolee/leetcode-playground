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
class BSTIterator {
    private List<Integer> list;
    private int currentIndex;
    
    public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        doLogic(root);
    }
    
    public int next() {
        int value = this.list.get(this.currentIndex);
        this.currentIndex++;
        return value;
    }
    
    public boolean hasNext() {
        return this.currentIndex < this.list.size();
    }
    
    private void doLogic(TreeNode root) {
        if (root != null) {
            doLogic(root.left);
            this.list.add(root.val);
            doLogic(root.right);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */