import java.util.*;
import java.util.stream.IntStream;

class Solution {
    final int[][] RULES = {
        {1,2,3,4,5},
        {2,1,2,3,2,4,2,5},
        {3,3,1,1,2,2,4,4,5,5}
    };
    
    private int getPicked(int student, int problem) {
        int[] rule = RULES[student];
        int index = problem % rule.length;
        return rule[index];
    }
    
    public int[] solution(int[] answers) {
        int[] corrects = new int[3];
        int max = 0;
        for (int problem = 0; problem < answers.length; problem++) {
            int answer = answers[problem];
            
            for (int student = 0; student < 3; student++) {
                int picked = getPicked(student, problem);
                if (answer == picked) {
                    if (++corrects[student] > max) {
                        max = corrects[student];
                    }
                }
            }
        }
        
        final int maxCorrects = max;
        return IntStream.range(0, 3)
            .filter(i -> corrects[i] == maxCorrects)
            .map(i -> i + 1)
            .toArray();
    }
}