class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            result.add(num * num);
        }

        return result.stream().mapToInt(it -> it).sorted().toArray();
    }
}