import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
                Map<Integer, Integer> stageCounts = new HashMap<>();
        for (int stage : stages) {
            int counts = stageCounts.getOrDefault(stage, 0) + 1;
            stageCounts.put(stage, counts);
        }

    Queue<Person> results = new PriorityQueue<>((o1, o2) -> {
        if (o2.rate.equals(o1.rate)) {
            return Integer.compare(o1.stage, o2.stage);
        }
        return o2.rate.compareTo(o1.rate);
    });
        int userCount = stages.length;
        for (int stage = 1; stage <= N; stage++) {
            Integer failCounts = stageCounts.getOrDefault(stage, 0);
            float rate = 0;
            if (failCounts != 0) {
                rate = (float) failCounts / userCount;
            }
            userCount -= failCounts;
            Person person = new Person(stage, rate);
            results.add(person);
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = results.poll().stage;
        }
        
        return answer;
    }
    
    public static class Person {
        Integer stage;
        Float rate;
        
        Person(Integer stage, Float rate) {
            this.stage = stage;
            this.rate = rate;
        }
    }
}