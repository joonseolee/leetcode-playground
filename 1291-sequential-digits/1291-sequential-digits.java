class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int startDigit = toDigit(low);
        int endDigit = toDigit(high);
        List<Integer> results = new ArrayList<>();

        for (int i = startDigit; i <= endDigit; i++) {
            for (int j = 1; j < 9; j++) {
                if (i + j > 10) {
                    continue;
                }

                int value = toSequential(i, j);
                if (value < low || value > high) {
                    continue;
                }
                results.add(value);
            }
        }

        return results;
    }
    
    private int toDigit(int value) {
        int result = 1;
        while (value > 9) {
            value = value / 10;
            result++;
        }
        
        return result;
    }
    
    private int toSequential(int size, int startValue) {
        int result = startValue;
        while (size > 1) {
            startValue++;
            result = result * 10 + startValue;
            size--;
        }
        
        return result;
    }
}