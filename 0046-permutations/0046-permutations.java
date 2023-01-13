class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solution(result, nums.length, nums, new ArrayList<Integer>());
        return result;
    }
    
    private void solution(List<List<Integer>> result, int length, int[] nums, List<Integer> values) {
        if (length == 0) {
            result.add(new ArrayList<>(values));
            return;
        }
        
        for (int i : nums) {
            List<Integer> isContains = values.stream().filter(it -> it == i).collect(Collectors.toList());
            if (isContains.size() == 0) {
                values.add(i);
                solution(result, length - 1, nums, values);
                values.remove(values.size() - 1);
            }
        }
    }
}