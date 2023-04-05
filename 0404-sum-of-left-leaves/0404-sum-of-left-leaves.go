/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sumOfLeftLeaves(root *TreeNode) int {
    return recursive(root, false)
}

func recursive(root *TreeNode, isLeft bool) int {
    if root == nil {
        return 0
    }
    
    if root.Left == nil && root.Right == nil {
        if isLeft {
            return root.Val
        }
        
        return 0
    }
    
    v1 := recursive(root.Left, true)
    v2 := recursive(root.Right, false)
    
    return v1 + v2
}