class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        for (int i = 0; i < 100; i++) {
            if (!isAvailable(word1, i)) {
                return result + word2.substring(i);
            }
            
            if (!isAvailable(word2, i)) {
                return result + word1.substring(i);
            }
            
            result = result + word1.charAt(i) + word2.charAt(i);
        }
        
        return result;
    }
    
    private boolean isAvailable(String value, int index) {
        try {
            value.charAt(index);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}