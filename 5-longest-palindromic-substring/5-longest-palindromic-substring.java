class Solution {
    private int startIndex;
    private int maxLength;
    
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        for (int i = 0 ; i < s.length() ; i++) {
            findMaxPalindrome(s, i, i);
            findMaxPalindrome(s, i, i + 1);
        }

        return s.substring(startIndex, startIndex + maxLength);
    }
    
    private void findMaxPalindrome(String text, int i, int j) {
        while (i >= 0 && j < text.length() && text.charAt(i) == text.charAt(j)) {
            i--;
            j++;
        }

        if (maxLength < j - i - 1) {
            startIndex = i + 1;
            maxLength = j - i - 1;
        }
    }
}