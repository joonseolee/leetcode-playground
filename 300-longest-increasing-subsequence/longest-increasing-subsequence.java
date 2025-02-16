class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> values = new ArrayList<>();
        for (int num : nums) {
            int index = Collections.binarySearch(values, num);

            if (index < 0) {
                index = -(index + 1);
            }

            if (index < values.size()) {
                values.set(index, num);
            } else {
                values.add(num);
            }
        }

        return values.size();
    }
}