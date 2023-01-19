/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func maxDepth(root *TreeNode) int {
    if root == nil {
        return 0
    }
    
    leftCount := solution(root.Left, 1)
    rightCount := solution(root.Right, 1)
    
    if leftCount > rightCount {
        return leftCount
    }
    
    return rightCount
}

func solution(node *TreeNode, count int) int {
    if node == nil {
        return count
    }
    
    leftCount := solution(node.Left, count + 1)
    rightCount := solution(node.Right, count + 1)
    
    if leftCount > rightCount {
        return leftCount
    }
    
    return rightCount
}