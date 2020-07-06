package leetcode;

public class q0012_整数转罗马数字 {

    class Solution {
        public String intToRoman(int num) {
            // 用于存储最终结果
            StringBuilder sb = new StringBuilder();
            // 用数组存储数字和对应的罗马数字
            int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] romes = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
            // 循环nums数组
            for (int i = 0; i < nums.length; i++) {
                // 如果数组中的当前数字一直小于等于num，则一直使用当前数字
                while (nums[i] <= num) {
                    num -= nums[i];
                    sb.append(romes[i]);
                }
            }
            return sb.toString();
        }
    }
}
