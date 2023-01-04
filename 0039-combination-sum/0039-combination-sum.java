import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList();
        combinations(candidates, target, result, 0, new ArrayList<>());
        return result;
    }
    
    private void combinations(int[] candidates,
                              int target,
                              List<List<Integer>> result, 
                              int index, 
                              List<Integer> values) {
        if (index == candidates.length) {
            if (target == 0) {
                result.add(new ArrayList<>(values));
            }
            
            return;
        }
        
        if (candidates[index] <= target) {
            values.add(candidates[index]);
            combinations(candidates, target - candidates[index], result, index, values);
            values.remove(values.size() - 1);
        }
        
        combinations(candidates, target, result, index + 1, values);
    }
}