# 6. Z 字形变换（中等）
将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。\
比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
```
L   C   I   R
E T O E S I I G
E   D   H   N
```
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。\
请你实现这个将字符串进行指定行数变换的函数：
```
string convert(string s, int numRows);
```
## 示例
*  示例1
    ```
    输入: s = "LEETCODEISHIRING", numRows = 3
    输出: "LCIRETOESIIGEDHN"
    ```
* 示例2
    ```
    输入: s = "LEETCODEISHIRING", numRows = 4
    输出: "LDREOEIIECIHNTSG"
    解释:
    L     D     R
    E   O E   I I
    E C   I H   N
    T     S     G
    ```

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 解答
### 解法1：二维数组
使用二维数组将字符串保存并形成输出。\
太过基础，不做讲解。
### 解法2：排序输出
使用List保存每一行，最后将List中所有行进行拼接
```java
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
```
