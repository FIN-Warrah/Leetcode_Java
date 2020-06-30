package leetcode;

import java.util.ArrayList;
import java.util.List;

public class q6_Z字形变换 {

    class Solution {
        public String convert(String s, int numRows) {

            if (numRows == 1) return s;

            // 保存所有行
            List<StringBuilder> rows = new ArrayList<>();
            // 字符串长度可能小于行数
            for (int i = 0; i < Math.max(numRows, s.length()); i++) {
                rows.add(new StringBuilder());
            }

            // 表示当前所在的行
            int currRow = 0;
            // 表示是否行数增加
            boolean down = false;

            for (char c : s.toCharArray()) {
                rows.get(currRow).append(c);
                if (currRow == 0 || currRow == numRows - 1) down = ! down;
                currRow += down ? 1: -1;
            }

            // 最后处理，获得结果
            StringBuilder res = new StringBuilder();
            for (StringBuilder row : rows) {
                res.append(row);
            }
            return res.toString();
        }
    }
}
