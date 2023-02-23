/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

import (
	"fmt"
)

var first *TreeNode
var second *TreeNode
var prev *TreeNode

func recoverTree(root *TreeNode)  {
    first = nil
    second = nil
    prev = nil
    inOrder(root)
    temp := first.Val
    first.Val = second.Val
    second.Val = temp
}

func inOrder(root *TreeNode) {
    if root == nil {
        return
    }
    
    inOrder(root.Left)
    if prev != nil && root.Val < prev.Val {
        if first == nil {
            first = prev
        }
        
        second = root
    }
    
    prev = root
    inOrder(root.Right)
}