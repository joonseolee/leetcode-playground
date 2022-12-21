import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String sortedText = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
            List<String> value = map.getOrDefault(sortedText, new ArrayList<>());
            value.add(str);
            map.put(sortedText, value);
        }
        
        return new ArrayList<>(map.values());
    }
}