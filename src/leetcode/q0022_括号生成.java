package leetcode;

import java.util.ArrayList;
import java.util.List;

public class q0022_括号生成 {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> res = new ArrayList<>();
            _recur(res, new StringBuilder(), 0, 0, n);
            return res;
        }

        private void _recur(List<String> res, StringBuilder currStr, int left, int right, int n) {
            //如果到达指定长度，则直接返回
            if (currStr.length() == n * 2) {
                res.add(currStr.toString());
                return;
            }
            // 如果左括号数量比指定数量小，则添加左括号并下探
            if (left < n) {
                currStr.append('(');
                _recur(res, currStr, left + 1, right, n);
                // 状态恢复
                currStr.deleteCharAt(currStr.length() - 1);
            }
            // 如果右括号数量小于左括号数量，则添加右括号并下探
            if (right < left) {
                currStr.append(')');
                _recur(res, currStr, left, right + 1, n);
                // 状态恢复
                currStr.deleteCharAt(currStr.length() - 1);
            }
        }
    }
}
