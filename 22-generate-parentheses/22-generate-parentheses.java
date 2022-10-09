class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        doLogic(result, n, 0, 0, "");
        return result;
    }
    
    private void doLogic(List<String> result, int maxPairs, int leftCount, int rightCount, String text) {
        if (maxPairs == leftCount && maxPairs == rightCount) {
            result.add(text);
            return;
        }

        if (maxPairs > leftCount) {
            doLogic(result, maxPairs, leftCount + 1, rightCount, text + "(");
        }
        if (maxPairs > rightCount && leftCount > rightCount) {
            doLogic(result, maxPairs, leftCount, rightCount + 1, text + ")");
        }
    }
}