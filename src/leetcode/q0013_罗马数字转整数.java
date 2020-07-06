package leetcode;

import java.util.HashMap;

public class q0013_罗马数字转整数 {
    class Solution {
        public int romanToInt(String s) {
            // 存储结果
            int res = 0;
            // 哈希表的初始化
            HashMap<String, Integer> map = new HashMap();
            map.put("I", 1);
            map.put("IV", 4);
            map.put("V", 5);
            map.put("IX", 9);
            map.put("X", 10);
            map.put("XL", 40);
            map.put("L", 50);
            map.put("XC", 90);
            map.put("C", 100);
            map.put("CD", 400);
            map.put("D", 500);
            map.put("CM", 900);
            map.put("M", 1000);
            // 循环遍历字符串
            for (int i = 0; i < s.length();) {
                // 这里表示查看两个字符
                if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                    res += map.get(s.substring(i, i + 2));
                    i += 2;
                } else {
                    res += map.get(s.substring(i, i + 1));
                    i ++;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int romanToInt(String s) {
            int res = 0;
            int preNum = getValue(s.charAt(0));
            for (int i = 1; i < s.length(); i++) {
                int num = getValue(s.charAt(i));
                // 如果前一位比这一位表示的数字小，则说明应该减去
                if (preNum < num)
                    res -= preNum;
                // 否则应该加上
                else
                    res += preNum;
                preNum = num;
            }
            // 加上最后一位
            res += preNum;
            return res;
        }

        private int getValue(char ch) {
            switch(ch) {
                case 'I': return 1;
                case 'V': return 5;
                case 'X': return 10;
                case 'L': return 50;
                case 'C': return 100;
                case 'D': return 500;
                case 'M': return 1000;
                default: return 0;
            }
        }
    }
}
