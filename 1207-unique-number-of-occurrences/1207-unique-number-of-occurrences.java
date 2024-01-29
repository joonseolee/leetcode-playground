import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : arr) {
            int temp = map.getOrDefault(value, 0);
            map.put(value, temp + 1);
        }

        int before = -1;
        for (int value : map.values().stream().sorted().collect(Collectors.toList())) {
            if (value == before) {
                return false;
            }

            before = value;
        }

        return true;
    }
}