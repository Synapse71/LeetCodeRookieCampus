class Solution {
    public int[] exchange(int[] nums) {
        int length = nums.length;
        int i = 0;
        int j = length - 1;
        while (i<j) {
            while (i < j && !isEven(nums[i])) {
                i++;
            }
            while (i < j && isEven(nums[j])) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    private boolean isEven(int num) {
        return (num % 2 == 0);
    }
}