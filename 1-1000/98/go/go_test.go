// https://leetcode-cn.com/problems/validate-binary-search-tree/
package golang

import "testing"

// Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 以中序遍历来判断是否违背递增
func isValidBST(root *TreeNode) bool {
	res := []int{}
	stack := []*TreeNode{}
	cur := root
	for cur != nil || len(stack) > 0 {
		for cur != nil {
			stack = append(stack, cur)
			cur = cur.Left
		}
		index := len(stack) - 1 //栈顶
		if len(res) == 0 || stack[index].Val > res[len(res)-1] {
			res = append(res, stack[index].Val) //出栈
		} else if stack[index].Val <= res[len(res)-1] {
			return false
		}
		cur = stack[index].Right //右节点会进入下次循环，如果 =nil，继续出栈
		stack = stack[:index]
	}
	return true
}

func TestIsValidBST(t *testing.T) {
	root1 := &TreeNode{Val: 1}
	root1.Left = &TreeNode{Val: 2}
	root1.Right = &TreeNode{Val: 3}
	root1.Left.Left = &TreeNode{Val: 4}
	root1.Left.Right = &TreeNode{Val: 5}
	root1.Right.Left = &TreeNode{Val: 6}
	root1.Right.Right = &TreeNode{Val: 7}
	root1.Left.Left.Right = &TreeNode{Val: 8}
	root1.Left.Right.Left = &TreeNode{Val: 9}
	//		  1
	//   2		   3
	// 4	5    6   7
	//  8 9
	t.Logf("%t\n", isValidBST(root1))

	root2 := &TreeNode{Val: 7}
	root2.Left = &TreeNode{Val: 4}
	root2.Right = &TreeNode{Val: 9}
	root2.Left.Left = &TreeNode{Val: 2}
	root2.Left.Right = &TreeNode{Val: 6}
	root2.Right.Left = &TreeNode{Val: 8}
	root2.Right.Right = &TreeNode{Val: 10}
	root2.Left.Left.Right = &TreeNode{Val: 3}
	root2.Left.Right.Left = &TreeNode{Val: 5}
	//		  7
	//   4		   9
	// 2	6    8   10
	//  3 5
	t.Logf("%t\n", isValidBST(root2))
}
