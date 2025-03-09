import java.util.*;
import java.util.stream.Collectors;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        var arrSize = s.length();
        
        for (int i = 0 ; i < arrSize ; i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(')');
                break;
            }
        }
        return stack.isEmpty();
    }
}