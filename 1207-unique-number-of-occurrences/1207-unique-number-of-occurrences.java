import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            int temp = map.getOrDefault(value, 0);
            map.put(value, temp + 1);
        }
        
        var set = new HashSet<Integer>();
    
        for (var val : map.values()) {
            if (set.contains(val)) {
              return false;
            }
            
            set.add(val);
        }

        return true;
    }
}