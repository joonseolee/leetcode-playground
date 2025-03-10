import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
                continue;
            }

            if (stack.peek() == c) {
                stack.pop();
                continue;
            }

            stack.add(c);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}