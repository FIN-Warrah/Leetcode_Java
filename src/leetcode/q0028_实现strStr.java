package leetcode;

public class q0028_实现strStr {

    class Solution {
        public int strStr(String haystack, String needle) {
            int hlen = haystack.length();
            int nlen = needle.length();

            if (nlen == 0) return 0;

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
}
