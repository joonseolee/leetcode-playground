import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        int l = 0;
        int max = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        for (int r = 0 ; r < s.length() ; r++) {
            char currentChar = s.charAt(r);
            if (map.containsKey(currentChar) && map.get(currentChar) >= l) {
                l = map.get(currentChar) + 1;
            }
            
            map.put(currentChar, r);
            max = Math.max(r - l + 1, max);
        }
        
        return max;
    }
}