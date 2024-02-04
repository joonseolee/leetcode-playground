class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char value : s.toCharArray()) {
            if (value == '*') {
                stack.pop();
                continue;
            }
            
            stack.add(value);
        }
        
        String result = "";
        while (!stack.isEmpty()) {
            result = String.valueOf(stack.pop()) + result;
        }
        
        return result;
    }
}