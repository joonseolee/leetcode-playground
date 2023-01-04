import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Combination> result = new HashSet();
        logic(result, candidates, new ArrayList<>(), 0, target);
        return result.stream()
            .map(Combination::getValues)
            .collect(Collectors.toList());
    }
    
    private void logic(Set<Combination> result,
                       int[] candidates,
                       List<Integer> values,
                       int valueSum,
                       int target) {
        if (valueSum == target) {
            result.add(new Combination(values));
            return;
        }

        for (int candidate : candidates) {
            int tempSum = valueSum + candidate;
            if (tempSum <= target) {
                List<Integer> recentValues = new ArrayList<>(values);
                recentValues.add(candidate);
                logic(result, candidates, recentValues, tempSum, target);
            }
        }
    }

    private static class Combination {
        private List<Integer> values;
        
        public Combination(List<Integer> numbers) {
            this.values = numbers.stream().sorted().collect(Collectors.toList());
        }
        
        public List<Integer> getValues() {
            return this.values;
        }
        
        @Override
        public int hashCode() {
            return Objects.hashCode(this.values);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }

            if (o instanceof Combination) {
                Combination other = (Combination) o;
                return this.hashCode() == other.hashCode();
            }

            return false;
        }
    }
}