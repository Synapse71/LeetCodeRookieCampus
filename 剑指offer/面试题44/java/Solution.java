class Solution {
    public int findNthDigit(int n) {
        int detectorLower = 0;
        int detectorUpper = 9; // 0-9
        int base = 1;
        while (n > detectorUpper) {
            base++;
            detectorLower = detectorUpper;
            detectorUpper += base * Math.pow(10, base - 1) * 9;
        }
        // 找到是哪一个数字
        int theNumber = (int)Math.ceil((double)(n - detectorLower) / base) + (int)Math.pow(10, base - 1) - 1;
        // 找到这个数字的第几位
        int indexInNumber = (n - detectorLower - 1) % base ;
        char digit = String.valueOf(theNumber).charAt(indexInNumber);
        return Integer.parseInt(new StringBuilder().append(digit).toString());
    }
}