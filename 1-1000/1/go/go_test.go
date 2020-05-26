// https://leetcode-cn.com/problems/two-sum/submissions/
package golang

import (
	"testing"
)

func twoSum(nums []int, target int) []int {
	temp := make(map[int]int)
	for i, v := range nums {
		find := target - v
		index, ok := temp[find]
		if ok {
			return []int{index, i}
		} else {
			temp[v] = i
		}
	}
	return nil
}

func TestTwoSum(t *testing.T) {
	array := []int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
	t.Logf("%#v\n", twoSum(array, 15))
}
