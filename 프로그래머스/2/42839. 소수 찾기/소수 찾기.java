import java.util.*;

class Solution {

    public int solution(String numbers) {
        char[] numArr = numbers.toCharArray();
        Set<Integer> result = new HashSet<>();

        for (int i = 0; i < numbers.length(); i++) {
            boolean[] visited = new boolean[numbers.length()];
            permutation(numArr, result, visited, i, 0);
        }

        return result.size();
    }

    private void permutation(char[] numArr, Set<Integer> result, boolean[] visited, int i, int value) {

        if (value != 0) {
            if (isPrime(value)) {
                result.add(value);
            }
        }
        
        if (getSize(value) == numArr.length) {
            return;
        }
        
        for(int k = 0; k < numArr.length; k++) {
            if (visited[k]) {
                continue;
            }
            
            int acc = value * 10 + (numArr[k] - '0');
            visited[k] = true;
            permutation(numArr, result, visited, i, acc);
            visited[k] = false;
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
    
    private int getSize(int value) {
        int count = 0;
        
        while (value > 0) {
            value = value / 10;
            count++;
        }
        
        return count;
    }
}