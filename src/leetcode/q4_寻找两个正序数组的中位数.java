package leetcode;

public class q4_寻找两个正序数组的中位数 {

    class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            // 将总长度为奇数和总长度为偶数的情况合并考虑。如果是奇数，则会求两次相同的值再除以2
            int left = (len1 + len2 + 1) / 2;
            int right = (len1 + len2 + 2) / 2;
            return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 0.5;
        }

        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            // 保证一定第一个数组长度小于第二个数组长度，即第一个数组先空
            if (len1 > len2)
                return getKth(nums2, start2, end2, nums1, start1, end1, k);
            // 如果第一个数组为空，则直接返回第二个数组的中位数
            if (len1 == 0)
                return nums2[start2 + k - 1];
            // 如果 k == 1，则返回两个数组的头元素中最小的哪个
            if (k == 1)
                return Math.min(nums1[start1], nums2[start2]);

            // 根据 k/2 从数组中删除
            int i = start1 + Math.min(len1, k / 2) - 1;
            int j = start2 + Math.min(len2, k / 2) - 1;
            // 如果 nums1[i] > nums2[j]，则从nums2中删除
            if (nums1[i] > nums2[j])
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            // 否则从nums1中删除
            else
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }
}
