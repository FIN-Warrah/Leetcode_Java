# 28. 实现 strStr（简单）
https://leetcode-cn.com/problems/implement-strstr/

实现 strStr() 函数。\
给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

## 示例
* 示例1
    ```
    输入: haystack = "hello", needle = "ll"
    输出: 2
    ```
* 示例2
    ```
    输入: haystack = "aaaaa", needle = "bba"
    输出: -1
    ```

## 说明
当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

## 解答
### 解法1：双指针
haystack和needle中各有一指针指示位置。
```java
class Solution {
    public int strStr(String haystack, String needle) {
        int hlen = haystack.length();
        int nlen = needle.length();

        if (nlen == 0) return 0;
        if (hlen == 0) return -1;

        // haystack的指针
        int hPointer = 0;

        while (hPointer < hlen - nlen + 1) {
            // 在haystack中找到与needle第一个字符相同的位置
            while (hPointer < hlen - nlen + 1 && haystack.charAt(hPointer) != needle.charAt(0))
                hPointer++;

            // needle的指针
            int nPointer = 0;

            int currLen = 0;
            while (nPointer < nlen && hPointer < hlen && haystack.charAt(hPointer) == needle.charAt(nPointer)) {
                hPointer++;
                nPointer++;
                currLen++;
            }

            // 如果长度与needle长度相同，说明找到，则直接返回
            if (currLen == nlen)
                return hPointer - nlen;

            // 如果没有找到，则haystack的指针回溯
            hPointer = hPointer - currLen + 1;
        }
        return -1;
    }
}
```
### 解法2：KMP算法
参考: https://leetcode-cn.com/problems/implement-strstr/solution/kmp-suan-fa-xiang-jie-by-labuladong/