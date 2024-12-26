import java.util.HashMap;

class Solution {
    private HashMap<String, Integer> memo = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return find(nums, target, 0, 0);
    }

    private int find(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            }

            return 0;
        }

        String key = index + "," + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // 두 가지 경우의 수를 계산
        int a = find(nums, target, index + 1, sum + nums[index]);
        int b = find(nums, target, index + 1, sum - nums[index]);

        // 결과를 저장하고 리턴
        int result = a + b;
        memo.put(key, result);
        return result;
    }
}