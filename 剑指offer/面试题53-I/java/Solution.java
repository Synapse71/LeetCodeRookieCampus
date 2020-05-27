class Solution {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0] == target ? 1: 0;
        }
        int lower = 0;
        int upper = length-1;
        int index = (lower + upper) / 2;
        if (nums[upper] == target) {
            index = upper;
        } else if(nums[lower] == target) {
            index = lower;
        } else {
            boolean contains = false;
            while (index != lower) {
                if (nums[index] == target) {
                    contains = true;
                    break;
                }
                if (nums[index] > target) {
                    upper = index;
                } else {
                    lower = index;
                }
                index = (lower + upper) / 2;
            }
            if (!contains) {
                return 0;
            }
        }
        int result = 1;
        int base = index;
        // forward
        while(index < length - 1 && nums[index + 1] == target) {
            result++;
            index++;
        }
        // backward
        while(base > 0 && nums[base - 1] == target) {
            result++;
            base--;
        }
        return result;
    }
}