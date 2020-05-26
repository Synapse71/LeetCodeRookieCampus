class Solution {

    public int cuttingRope(int n) {
        int[] cache = new int[n+1];
        return remember(n, cache);
    }

    private int remember(int n, int[] cache) {
        if (n == 2) {
            return 1;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int result = -1;
        for (int i = 1; i< n-1; i++) {
            result = Math.max(result, Math.max(i * (n-i), i * remember(n-i, cache)));
        }
        cache[n] = result;
        return result;
    }
}