/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    var result [][]int
    recursive(&result, root, 0)
    return result
}

func recursive(result *[][]int, root *TreeNode, level int) {
    if root == nil {
        return
    }
    
    if len(*result) < level + 1 {
        *result = append(*result, []int{})
    }
    
    (*result)[level] = append((*result)[level], root.Val)
    recursive(result, root.Left, level + 1)
    recursive(result, root.Right, level + 1)
}