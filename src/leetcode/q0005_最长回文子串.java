package leetcode;

public class q0005_最长回文子串 {

    class Solution {
        public String longestPalindrome(String s) {
           int len = s.length();
           // 如果字符串长度为0或1，则直接返回
           if (len < 2) return s;
           // maxLen表示最终返回的结果
           int maxLen = 1;

           int begin = 0;

           // 动态规划数组定义
            boolean dp[][] = new boolean[len][len];
            char[] chars = s.toCharArray();

            // 单个字符的子串一定是回文串
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }

            // 遍历子串的头和尾，由于之前考虑过单字符的情况，因此这里不再考虑
            // 循环顺序需要注意！！
            for (int j = 1; j < len; j++) {
                for (int i = j - 1; i > 0; i--) {
                    // 如果头和尾的字符不相同，则直接排除
                    if (chars[i] != chars[j])
                        dp[i][j] = false;
                    else {
                        // 如果当前字符串长度只有3，且头字符和尾字符相等，则为true
                        if (j - i <= 2)
                            dp[i][j] = true;
                        else
                            dp[i][j] = dp[i + 1][j - 1];
                    }

                    // 如果是回文串，则记录长度和起始位置
                    if (dp[i][j] == true && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }

            return s.substring(begin, begin + maxLen);
        }
    }
}
