package leetcode;

public class q0008_字符串转换整数_atoi {

    public static void main(String[] args) {

        class Solution {
            public int myAtoi(String str) {
                // 删除字符串首尾空格（这里的作用是删除字符串最前面的空格）
                str = str.trim();
                if (str.length() == 0) return 0;
                // flag表示正负
                int flag = 1;
                // 将字符串转换为字符数组，便于遍历
                char[] chars = str.toCharArray();
                // res为最终的结果
                int res = 0;

                int start = 0;
                // 判断正负
                if (chars[0] == '+' || chars[0] == '-') {
                    if (chars[0] == '-') {
                        flag = -1;
                    }
                    start = 1;
                }

                // 遍历字符串
                for (int i = start; i < chars.length; i++) {
                    if (chars[i] < '0' || chars[i] > '9') break;
                    int thisNum = chars[i] - '0';
                    // 判断边界条件
                    if (flag == 1 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && thisNum > 7)))
                        return Integer.MAX_VALUE;
                    if (flag == -1 && (res > - (Integer.MIN_VALUE / 10) || (res == -(Integer.MIN_VALUE / 10) && thisNum > 8)))
                        return Integer.MIN_VALUE;

                    res = res * 10 + thisNum;
                }

                return res * flag;
            }
        }
    }
}
