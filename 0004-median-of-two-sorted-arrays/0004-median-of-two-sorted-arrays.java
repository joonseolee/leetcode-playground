class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            n = nums1.length;
            m = nums2.length;
        }

        int left = 0, right = n;
        int halfCount = (n + m + 1) >> 1;

        // Binary Search
        while (left < right) {
            int i = (left + right + 1) >> 1;
            int j = halfCount - i;

            if (nums1[i - 1] > nums2[j]) right = i - 1;
            else left = i;
        }

        //median
        int i = left;
        int j = halfCount - i;
        int nums1MinValue = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums2MinValue = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int leftMax = Math.max(nums1MinValue, nums2MinValue);
        if ((n + m) % 2 == 1) {
            return leftMax;
        }

        int nums1MaxValue = i == n ? Integer.MAX_VALUE : nums1[i];
        int nums2MaxValue = j == m ? Integer.MAX_VALUE : nums2[j];
        int rightMin = Math.min(nums1MaxValue, nums2MaxValue);
        return (leftMax + rightMin) / 2.0;
    }
}