// https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
package golang

import "testing"

// Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	var res []int
	var stack []*TreeNode
	cur := root
	for 0 < len(stack) || cur != nil {
		for cur != nil {
			stack = append(stack, cur) // 自己入栈
			cur = cur.Left             // 移至最左
		}
		index := len(stack) - 1             //栈顶
		res = append(res, stack[index].Val) //出栈
		cur = stack[index].Right            //右节点会进入下次循环，如果 =nil，继续出栈
		stack = stack[:index]
	}
	return res
}

func TestInorderTraversal(t *testing.T) {
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
	t.Logf("%#v\n", inorderTraversal(root))
}
