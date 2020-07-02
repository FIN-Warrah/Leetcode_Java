package leetcode;

import java.util.Arrays;

public class q16_最接近的三数之和 {

    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            // 因为限制了3 <= nums.length <= 10^3，因此不做错误排除

            Arrays.sort(nums);
            int res = nums[0] + nums[1] + nums[2];
            for (int i = 0; i < nums.length; i++) {
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    // 如果相等，则直接返回
                    if (sum == target) return target;
                    // 其他情况
                    if (Math.abs(target - sum) < Math.abs(target - res))
                        res = sum;
                    if (sum > target)
                        right--;
                    else if (sum < target)
                        left++;
                }
            }
            return res;
        }
    }
}
