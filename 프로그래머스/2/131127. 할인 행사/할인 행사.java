import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int right = 0;
        int left = 0;
        while (right < 10) {
            map.computeIfPresent(discount[right], (k, v) -> v - 1);
            right++;
        }

        int result = 0;
        if (isBoughtAll(map)) {
            result++;
        }

        while (right < discount.length) {
            map.computeIfPresent(discount[left], (k, v) -> v + 1);
            left++;
            map.computeIfPresent(discount[right], (k, v) -> v - 1);
            right++;

            if (isBoughtAll(map)) {
                result++;
            }
        }

        return result;
    }

    private boolean isBoughtAll(Map<String, Integer> map) {
        for (int count : map.values()) {
            if (count > 0) {
                return false;
            }
        }

        return true;
    }
}