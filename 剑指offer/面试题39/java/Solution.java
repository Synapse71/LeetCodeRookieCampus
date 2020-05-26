class Solution {
    public int majorityElement(int[] nums) {
        int base = 0;
        int counter = 0;
        for (int index = 0; index < nums.length; index++) {
            if (counter == 0) {
                base = nums[index];
                counter++;
            } else {
                if (base == nums[index]) {counter++;} else { counter--;}
            }
        }
        return base;
    }
}