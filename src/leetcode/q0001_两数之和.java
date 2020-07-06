package leetcode;

import java.util.HashMap;

public class q0001_两数之和 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int another = target - nums[i];
                // 如果找到了，则直接返回
                if (map.containsKey(another))
                    return new int[] {map.get(another), i};
                // 如果没找到，则将当前元素插入map中
                map.put(nums[i], i);
            }
            return new int[] {};
        }
    }
}
