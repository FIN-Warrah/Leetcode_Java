package leetcode;

public class q11_盛最多水的容器 {

    class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = Math.min(height[left], height[right]) * (right - left);
            while (left < right) {
                if (height[left] < height[right])
                    left ++;
                else
                    right --;
                maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            }
            return maxArea;
        }
    }
}
