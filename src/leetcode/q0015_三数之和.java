package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q0015_三数之和 {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            // 返回结果
            List<List<Integer>> res = new ArrayList<>();
            // 错误排除
            if (nums == null || nums.length < 3) return res;
            // 排序
            Arrays.sort(nums);
            // 遍历
            for (int i = 0; i < nums.length; i++) {
                // 如果当前数字大于0，则三数之和一定大于0
                if (nums[i] > 0) break;
                // 去重
                if (i > 0 && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    // 此时的三数之和
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        // 去重
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum < 0) left++;
                    else if (sum > 0) right--;
                }
            }
            return res;
        }
    }
}
