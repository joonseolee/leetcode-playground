import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Long> completionMap = Arrays.stream(completion)
                .collect(Collectors.groupingBy(it -> it, Collectors.counting()));

        for (String person : participant) {
            if (completionMap.get(person) == null || completionMap.get(person) == 0) {
                return person;
            }

            completionMap.computeIfPresent(person, (k, v) -> v - 1);
        }
        
        return "";
    }
}