package leetcode;

import java.util.Stack;

public class q20_有效的括号 {

    class Solution {
        public boolean isValid(String s) {
            // 错误排除
            if (s == null || s.length() % 2 == 1) return false;
            if (s.equals("")) return true;
            if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') return false;
            // 栈
            Stack<Character> stack = new Stack<>();
            // 遍历字符串
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(')
                    stack.push(')');
                else if (s.charAt(i) == '[')
                    stack.push(']');
                else if (s.charAt(i) == '{')
                    stack.push('}');
                else {
                    if (s.charAt(i) == stack.peek())
                        stack.pop();
                    else
                        return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
