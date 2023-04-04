/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    
    result := TreeNode{Val: root.Val}
    result.Left = invertTree(root.Right)
    result.Right = invertTree(root.Left)
    
    return &result
}