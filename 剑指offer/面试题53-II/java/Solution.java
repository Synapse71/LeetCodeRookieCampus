class Solution {
    public int missingNumber(int[] nums) {
        int upper = nums.length - 1;
        int lower = 0;

        while (true) {
            int index = (upper + lower) / 2;
            if (index == lower) {
                if (index == nums[index]) {
                    index = upper;
                } else {
                    return index;
                }
            }
            if (index == upper) {
                return index == nums[index] ? index + 1 : index;
            }
            if (nums[index] != index) {
                upper = index;
            } else {
                lower = index;
            }
        }
    }
}