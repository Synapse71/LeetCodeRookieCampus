class Solution {
    public int maxSubArray(int[] nums) {
        int result = 0;
        for (int index = 0; index < nums.length; index++) {
            if (index == 0) {
                result = nums[index];
                continue;
            }
            nums[index] = Math.max(nums[index], nums[index - 1] + nums[index]);
            result = Math.max(nums[index], result);
        }
        return result;
    }
}