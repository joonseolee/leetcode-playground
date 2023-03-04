/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
    values := make([]int, 0)
    dfs(root, &values)
    
    return values
}

func dfs(root *TreeNode, values *[]int) {
    if root == nil {
        return
    }
    
    dfs(root.Left, values)
	*values = append(*values, root.Val)
    dfs(root.Right, values)
}
