package leetcode;

public class q10_正则表达式匹配 {

    class Solution {
        public boolean isMatch(String s, String p) {
            int len1 = s.length();
            int len2 = p.length();
            boolean dp[][] = new boolean[len1 + 1][len2 + 1];
            dp[0][0] = true;
            for (int i = 0; i <= len1; i++) {
                // 从[0][1]开始，因为[0][0]已经有值
                for (int j = 1; j <= len2; j++) {
                    // 如果p的当前字符不是'*'
                    if (p.charAt(j - 1) != '*') {
                        if (match(s, i, p, j)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                    // 如果p的当前字符是'*'
                    else {
                        if (match(s, i, p, j - 1)) {
                            dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
                        } else {
                            dp[i][j] = dp[i][j - 2];
                        }
                    }
                }
            }
            return dp[len1][len2];
        }

        // s的第i-1个字符和p的第j-1个字符是否能匹配
        public boolean match(String s, int i, String p, int j) {
            if (i == 0)
                return false;
            if (p.charAt(j - 1) == '.')
                return true;
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
}
