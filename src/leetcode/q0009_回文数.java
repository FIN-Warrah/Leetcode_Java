package leetcode;

public class q0009_回文数 {

    class Solution {
        public boolean isPalindrome(int x) {
            // 排除特殊情况
            if (x < 0 || (x % 10 == 0 && x != 0)) return false;
            // another表示反转后的后一半
            int another = 0;
            // 当前一半小于或等于反转后的后一半时，循环结束
            while (! (x <= another)) {
                another = another * 10 + x % 10;
                x /= 10;
            }
            // x的长度为偶数或x的长度为奇数
            return x == another || x == another / 10;
        }
    }
}
