class Solution {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        double result;
        int tempN;
        if (n == Integer.MIN_VALUE) {
            tempN = Integer.MAX_VALUE;
        } else {
            tempN = n > 0 ? n : -n;
        }
        List<Double> powers = new ArrayList<>();
        powers.add(1.0);
        double base = 1.0;
        long loop = 0;
        while (loop * loop <= tempN) {
            loop++;
            base *= x;
            powers.add(base);
        }
        int times = (int) (tempN / loop);
        int rest = (int) (tempN % loop);
        result = 1.0;
        for (int i = 0; i < times; i++) {
            result *= powers.get((int) loop);
        }
        result *= powers.get(rest);
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                result *= x;
            }
            result = 1 / result;
        }
        return result;
    }
}