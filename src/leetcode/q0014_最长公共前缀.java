package leetcode;

public class q0014_最长公共前缀 {

    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0 || strs == null) return "";
            String res = strs[0];
            for (int i = 1; i < strs.length; i++) {
                res = getPrefix(res, strs[i]);
            }
            return res;
        }

        // 获取两个字符串的最长公共子串
        public String getPrefix(String s1, String s2) {
            int len = Math.min(s1.length(), s2.length());
            int index = 0;
            while (index < len && s1.charAt(index) == s2.charAt(index))
                index++;
            return s1.substring(0, index);
        }
    }

    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0 || strs == null) return "";
            return subArrayPrefix(strs, 0, strs.length - 1);
        }

        // 分治的数组一部分的最长公共前缀
        public String subArrayPrefix(String[] strs, int start, int end) {
            // 如果当前子数组只有一个元素，则直接返回
            if (start == end) return strs[start];
            // 其他情况
            int mid = (end - start) / 2 + start;
            String leftPrefix = subArrayPrefix(strs, start, mid);
            String rightPrefix = subArrayPrefix(strs, mid + 1, end);
            return getPrefix(leftPrefix, rightPrefix);
        }

        // 获取两个字符串的最长公共子串
        public String getPrefix(String s1, String s2) {
            int len = Math.min(s1.length(), s2.length());
            int index = 0;
            while (index < len && s1.charAt(index) == s2.charAt(index))
                index++;
            return s1.substring(0, index);
        }
    }
}
