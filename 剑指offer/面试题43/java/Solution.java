class Solution {
    public int countDigitOne(int n) {
        if (n == 0) {
            return 0;
        }
        int digitCount = 0;
        int base = 10;
        while (n / base > 0) {
            digitCount++;
            base *= 10;
        }
        return countDigitOne(n, digitCount);
    }

    private int countDigitOne(int number, int digit) {
        // 0-个位，1-十位，2-百位，以此类推
        if (digit == 0) {
            int count = number / 10;
            count += number % 10 >= 1 ? 1 : 0;
            return count;
        }
        else {
            long base = (int)Math.pow(10.0, digit);
            long count = number / (base * 10) * base;
            long rest = number % (base * 10);
            count += Math.max(Math.min(rest - base + 1, base), 0);
            return (int)count + countDigitOne(number, digit - 1);
        }
    }
}