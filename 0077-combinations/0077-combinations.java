class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> values = new ArrayList<>();
            values.add(i);
            solution(result, n, k, values);
        }
        
        return result;
    }
    
    private void solution(List<List<Integer>> result, int n, int k, List<Integer> values) {
        if (values.size() == k) {
            result.add(values);
            return;
        }
        
        int lastValue = values.get(values.size() - 1);
        for (int i = lastValue; i < n; i++) {
            List<Integer> newValues = new ArrayList<>(values);
            newValues.add(i + 1);
            solution(result, n, k, newValues);
        }
    }
}