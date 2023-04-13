class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        
        int index = 0;
        for (int value : pushed) {
            stack.push(value);
            
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        
        return stack.isEmpty();
    }
}