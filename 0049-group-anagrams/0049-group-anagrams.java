import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int hash = getKey(str);
            List<String> value = map.getOrDefault(hash, new ArrayList<>());
            value.add(str);
            map.put(hash, value);
        }
        
        return new ArrayList<>(map.values());
    }
    
    public int getKey(String s) {
        // # convert count to char again
        int[] map = new int[26];
        for(char c: s.toCharArray()) {
            map[c - 'a']++;
        }
        return Arrays.hashCode(map);
    }
}