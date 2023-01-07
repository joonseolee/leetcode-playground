class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        
        int[] wordLocations = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            wordLocations[s1.charAt(i) - 'a']++;
            wordLocations[s2.charAt(i) - 'a']--;
        }
        
        if (isZero(wordLocations)) {
            return true;
        }
        
        for (int i = s1.length(); i < s2.length(); i++) {
            wordLocations[s2.charAt(i) - 'a']--;
            wordLocations[s2.charAt(i - s1.length()) - 'a']++;
            if (isZero(wordLocations)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean isZero(int[] wordLocations) {
        for (int value : wordLocations) {
            if (value != 0) {
                return false;
            }
        }
        
        return true;
    }
}