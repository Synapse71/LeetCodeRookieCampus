class Solution {
    public int add(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        int factor1 = (a ^ b);
        int factor2 = ((a & b) << 1);
        return add(factor1, factor2);
    }
}