class Solution {
    public int[] twoSum(int[] nums, int target) {
        int index1 = 0;
        int index2 = nums.length - 1;
        while (index1 != index2) {
            if (nums[index1] + nums[index2] == target) {
                break;
            } else {
                if (nums[index1]  + nums[index2] > target) {
                    index2--;
                } else {
                    index1++;
                }
            }
        }
        return new int[]{nums[index1], nums[index2]};
    }
}