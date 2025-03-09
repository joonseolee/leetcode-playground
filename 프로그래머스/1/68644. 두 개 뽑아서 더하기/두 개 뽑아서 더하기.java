import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> values = new TreeSet<>(Integer::compareTo);

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int value = numbers[i] + numbers[j];
                values.add(value);
            }
        }

        return values.stream()
            .mapToInt(it -> it)
            .toArray();
    }
}