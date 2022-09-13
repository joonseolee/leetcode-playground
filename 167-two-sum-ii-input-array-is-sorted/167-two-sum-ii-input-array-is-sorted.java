class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int last = numbers.length - 1;
        int[] result = new int[2];
        
        while (first < last) {
            int sum = numbers[first] + numbers[last];
            if (sum < target) {
                first++;
            } else if (sum > target) {
                last--;
            } else {
                result[0] = first + 1;
                result[1] = last + 1;
                break;
            }
        }
        
        return result;
    }
}