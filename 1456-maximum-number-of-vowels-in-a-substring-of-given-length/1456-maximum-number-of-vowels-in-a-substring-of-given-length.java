class Solution {
    public int maxVowels(String s, int k) {
        int current = 0;
        int start = 0;
        int end = k - 1;
        for (int i = 0; i < k; i++) {
            if (isVowelLetter(s.charAt(i))) {
                current++;
            }
        }
        
        int result = current;
        start++;
        end++;
        while (end < s.length()) {
            current = require(s, current, start, end);
            result = Math.max(result, current);
            
            start++;
            end++;
        }
        
        return result;
    }
    
    private boolean isVowelLetter(char v) {
        return v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u';
    }
    
    private int require(String s, int count, int start, int end) {
        count = isVowelLetter(s.charAt(start - 1)) ? count - 1 : count;
        count = isVowelLetter(s.charAt(end)) ? count + 1 : count;
        
        return count;
    }
}