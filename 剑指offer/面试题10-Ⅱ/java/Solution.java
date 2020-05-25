class Solution {
    public int numWays(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int base1 = 1;
        int base2 = 2;
        int sum = 0;
        for (int stage = 3; stage <= n; stage++) {
            sum = (base1+base2)%1000000007;
            base1 = base2;
            base2 = sum;
        }
        return sum;
    }
}