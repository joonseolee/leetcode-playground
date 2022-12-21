class Solution {
    public int lengthOfLastWord(String s) {
        int result = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) == ' ' && result != 0) {
                return result;
            }
            
            if (s.charAt(i) != ' ') {
                result++;
            }
        }
        
        return result;
    }
}