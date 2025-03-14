import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int day = 0;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int remainPercentage = 100 - progress;

            if (speeds[i] * day >= remainPercentage) {
                count++;
                continue;
            }

            result.add(count);
            count = 0;
            day = 0;
            if (remainPercentage % speeds[i] != 0) {
                day = remainPercentage / speeds[i] + 1 + day;
            } else {
                day = remainPercentage / speeds[i] + day;
            }

            count++;
        }

        if (count != 0) {
            result.add(count);
        }

        return IntStream.range(1, result.size()).map(result::get).toArray();
    }
}