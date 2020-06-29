package leetcode;

import java.util.HashMap;

public class q3_无重复字符的最长子串 {

    class Solution {

        public int lengthOfLongestSubstring(String s) {
            // 错误排除
            if (s.length() == 0) return 0;
            // max表示结果（符合条件的子串的最大长度）
            int max = 0;
            // map表示每个字符出现的位置
            HashMap<Character, Integer> map = new HashMap<>();
            // left为左指针
            int left = 0;
            // i为右指针，遍历，同时更新左指针
            for (int right = 0; right < s.length(); right++) {
                // 如果扫描到了重复元素，则更新left的位置
                if (map.containsKey(s.charAt(right)))
                    left = Math.max(left, map.get(s.charAt(right)) + 1);
                // 如果是重复元素，则put是更新操作；如果不是重复元素，则put是添加操作
                map.put(s.charAt(right), right);
                // 更新结果
                max = Math.max(max, right -left + 1);
            }
            return max;
        }
    }
}
