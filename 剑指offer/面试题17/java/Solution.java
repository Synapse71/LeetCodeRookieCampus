class Solution {
    public int[] printNumbers(int n) {
        int loop = (int)Math.pow(10, n);
        int[] res = new int[loop-1];
        for (int i = 1; i < loop; i++) {
            res[i-1] = i;
        }
        return res;
    }
}