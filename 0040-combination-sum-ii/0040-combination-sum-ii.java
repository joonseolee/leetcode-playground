import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, target, result, new ArrayList<>(), 0);
        
        return result;
    }
    
    private void backtracking(int[] candidates, int target, List<List<Integer>> result, List<Integer> values, int index) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            result.add(new ArrayList<>(values));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if(i > index && candidates[i] == candidates[i - 1]) 
                continue;
            
            int value = candidates[i];
            values.add(value);
            backtracking(candidates, target - value, result, values, i + 1);
            values.remove(values.size() - 1);
        }
    }
}