package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q18_四数之和 {

    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            // 排除错误情况
            if(nums == null || nums.length < 4) return res;
            // 数组长度
            int len = nums.length;
            // 从小到大排序
            Arrays.sort(nums);
            // 开始循环：第一个指针
            for (int i = 0; i < len - 3; i++) {
                // 去除重复
                if (i > 0 && nums[i] == nums[i - 1])
                    continue;
                // 第二个指针
                for (int j = i + 1; j < len - 2; j++) {
                    // 去除重复
                    if (j > i + 1 && nums[j] == nums[j - 1])
                        continue;
                    // 第三个指针（左指针）
                    int left = j + 1;
                    // 第四个指针（右指针）
                    int right = len - 1;
                    while (left < right) {
                        int curr = nums[i] + nums[j] + nums[left] + nums[right];
                        if (curr == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;
                            // 去重
                            while (left < right && nums[left] == nums[left - 1])
                                left++;

                            right--;
                            // 去重
                            while (left < right && nums[right] == nums[right + 1])
                                right--;
                        } else if (curr < target) {
                            left++;
                        } else {
                            right --;
                        }
                    }
                }
            }
            return res;
        }
    }
}
