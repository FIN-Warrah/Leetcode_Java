package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q17_电话号码的字母组合 {

    class Solution {
        public List<String> res = new ArrayList<>();
        public String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return res;
            recur(digits, 0, "");
            return res;
        }

        public void recur(String digits, int index, String str) {
            if (index == digits.length()) {
                res.add(str);
                return;
            }
            int thisI = Integer.parseInt("" + digits.charAt(index));
            String letters = dict[thisI];
            for (int i = 0; i < letters.length(); i++) {
                recur(digits, index + 1, str + letters.charAt(i));
            }
        }
    }

    class Solution2 {
        public List<String> res = new ArrayList<>();
        public String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> queue = new LinkedList<>();

        public List<String> letterCombinations(String digits) {
            if (digits.length() == 0) return res;
            queue.offer("");
            char[] chars = digits.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String thisStr = queue.poll();
                    String letterStr = dict[chars[i] - '0'];
                    for (int k = 0; k < letterStr.length(); k++) {
                        queue.offer(thisStr + letterStr.charAt(k));
                    }
                }
            }
            return queue;
        }

    }
}
