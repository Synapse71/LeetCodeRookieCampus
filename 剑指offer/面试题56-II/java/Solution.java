class Solution {
    public int singleNumber(int[] nums) {
        int[] bitCounter = new int[32];
        for (int num:nums) {
            for (int digit = 0; digit < 32; digit++) {
                bitCounter[digit] += num & 1;
                num >>= 1;
            }
        }
        int result = 0;
        for (int digit = 31; digit > 0; digit--) {
            result += bitCounter[digit] % 3;
            result <<= 1;
        }
        result += bitCounter[0] % 3;
        return result;
    }
}