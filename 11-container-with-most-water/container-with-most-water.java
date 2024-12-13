class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        return acquireMaxArea(left, right, height, Integer.MIN_VALUE);
    }

    private int acquireMaxArea(int left, int right, int[] height, int maxValue) {
        if (left == right || left > right) {
            return maxValue;
        }

        int horizontal = right - left;
        int vertical = acquireVertical(height[left], height[right]);
        int size = horizontal * vertical;
        maxValue = Math.max(size, maxValue);

        // 왼쪽 값 뺴는것
        if (height[left] > height[right]) {
            maxValue = acquireMaxArea(left, right - 1, height, maxValue);
        } else {
            maxValue = acquireMaxArea(left + 1, right, height, maxValue);
        }

        return maxValue;
    }

    private int acquireVertical(int left, int right) {
        if (left == right) {
            return left;
        }

        if (left < right) {
            return left;
        }

        return right;
    }
}