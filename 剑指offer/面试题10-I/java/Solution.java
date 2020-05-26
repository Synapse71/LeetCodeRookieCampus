class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int loop = 0;
        int peiBo = 1;
        int last = 0;
        while(loop < n - 1) {
            int oldPeiBo = peiBo;
            peiBo = oldPeiBo + last;
            if (peiBo > 1000000007) {
                peiBo %= 1000000007;
            }
            last = oldPeiBo;
            loop++;
        }
        return peiBo;
    }
}