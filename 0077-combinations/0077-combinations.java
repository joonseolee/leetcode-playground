class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        solution(result, 1, n, k, new ArrayList<Integer>());
        return result;
    }
    
    private void solution(List<List<Integer>> result, int start, int n, int k, List<Integer> values) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(values));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            values.add(i);
            solution(result, i + 1, n, k - 1, values);
            values.remove(values.size() - 1);
        }
    }
    
}