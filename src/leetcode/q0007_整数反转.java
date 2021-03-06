package leetcode;

public class q0007_整数反转 {

    class Solution {
        public int reverse(int x) {
            int res = 0;
            while (x != 0) {
                int pop = x % 10;
                x /= 10;
                // 2147483647
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))
                    return 0;
                // -2147483648
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8))
                    return 0;
                res = res * 10 + pop;
            }
            return res;
        }
    }
}
