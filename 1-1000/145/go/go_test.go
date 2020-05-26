// https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
package golang

import "testing"

// Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func postorderTraversal(root *TreeNode) []int {
	res := []int{}
	if root == nil {
		return res
	}
	stack := []*TreeNode{root}
	for len(stack) > 0 {
		cur := stack[len(stack)-1]
		if cur.Right != nil {
			stack = append(stack, cur.Right)
		}
		if cur.Left != nil {
			stack = append(stack, cur.Left)
		}
		if cur.Left == nil && cur.Right == nil {
			res = append(res, cur.Val)
			stack = stack[:len(stack)-1]
		}
		cur.Left = nil
		cur.Right = nil
	}
	return res
}

func TestPostorderTraversal(t *testing.T) {
	root := &TreeNode{Val: 1}
	root.Left = &TreeNode{Val: 2}
	root.Right = &TreeNode{Val: 3}
	root.Left.Left = &TreeNode{Val: 4}
	root.Left.Right = &TreeNode{Val: 5}
	root.Right.Left = &TreeNode{Val: 6}
	root.Right.Right = &TreeNode{Val: 7}
	root.Left.Left.Right = &TreeNode{Val: 8}
	root.Left.Right.Left = &TreeNode{Val: 9}
	//		  1
	//   2		   3
	// 4	5    6   7
	//  8 9
	t.Logf("%#v\n", postorderTraversal(root))
}
