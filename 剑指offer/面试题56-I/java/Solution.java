class Solution {
    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int num:nums) {
            xor ^= num;
        }
        int mask = 1;
        while ((mask & xor) == 0) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int num:nums) {
            if ((mask & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a,b};
    }
}