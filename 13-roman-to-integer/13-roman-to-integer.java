import java.util.*;

class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);
        Queue<String> queue = new LinkedList<>(Arrays.asList(s.split("")));

        int acc = 0;
        int prevValue = map.get(queue.poll());
        while (!queue.isEmpty()) {
            int curValue = map.get(queue.poll());

            if (prevValue > curValue) {
                acc += prevValue;
                prevValue = curValue;
                continue;
            }

            if (prevValue == curValue) {
                acc += prevValue;
                continue;
            }

            if (prevValue == -1) {
                prevValue = curValue;
                continue;
            }

            acc += curValue - prevValue;
            prevValue = -1;
        }

        int result = prevValue == -1 ? acc : acc + prevValue;
        return result;
    }
}