class Solution {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] res = new int[a.length];
        // 下三角
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        // 上三角
        int base = 1;
        for (int i = a.length - 2; i >=0; i--) {
            base *= a[i + 1];
            res[i] *= base;
        }
        return res;
    }
}