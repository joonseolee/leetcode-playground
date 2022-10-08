class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length - 2 ; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int a = nums[i];
            int firstIndex = i + 1;
            int lastIndex = nums.length - 1;
            while (firstIndex < lastIndex) {
                int b = nums[firstIndex];
                int c = nums[lastIndex];

                if (a + b + c == 0) {
                    result.add(Arrays.asList(a, b, c));
                    
                    while (firstIndex < lastIndex && nums[firstIndex] == nums[firstIndex + 1]) {
                        firstIndex++;
                    }
                    
                    while (firstIndex < lastIndex && nums[lastIndex] == nums[lastIndex - 1]) {
                        lastIndex--;
                    }
                    
                    firstIndex++;
                    lastIndex--;
                } else if (a + b + c > 0) {
                    lastIndex--;
                } else {
                    firstIndex++;
                }
            }
        }

        return result;
    }
}