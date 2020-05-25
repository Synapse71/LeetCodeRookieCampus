class Solution {
    private int count;

    public int movingCount(int m, int n, int k) {
        count = 0;
        boolean[][] map = new boolean[n][m];
        travel(map, 0, 0, k);
        return count;
    }

    private void travel(boolean[][] map, int m, int n, int k) {
        if (m < 0 || n < 0 || n > map.length - 1 || m > map[0].length -1) {
            return;
        }
        if (digitalSum(m) + digitalSum(n) > k) {
            return;
        }
        if (map[n][m]) {
            return;
        }
        count++;
        map[n][m] = true;
        travel(map, m+1, n, k);
        travel(map, m, n+1, k);
        travel(map, m-1, n, k);
        travel(map, m, n-1, k);
    }

    private int digitalSum(int num) {
        int sum = 0;
        int base = 10;
        while (num > 0) {
            int rest = num % base;
            num -= rest;
            sum += rest * 10 / base;
            base *= 10;
        }
        return sum;
    }
}