/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func flatten(root *TreeNode)  {
    dfs(root)
}

func dfs(root *TreeNode) *TreeNode {
    if root == nil {
        return nil
    }
    
    if root.Left == nil && root.Right == nil {
        return root
    }
    
    left := dfs(root.Left)
    right := dfs(root.Right)
    
    root.Left = nil;
    if left != nil {
        root.Right = left
        
        for left.Right != nil {
            left = left.Right
        }
        left.Right = right
    }
    
    return root
}