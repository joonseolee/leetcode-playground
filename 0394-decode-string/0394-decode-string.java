class Solution {
    public String decodeString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<StringBuilder> stackBuilder = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int n = 0;
        
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                n = n * 10 + (ch - '0');
            } else if (ch == '[') {
                stack.push(n);
                n = 0;
                stackBuilder.push(builder);
                builder = new StringBuilder();
            } else if (ch == ']') {
                int repeat = stack.pop();
                String temp = builder.toString().repeat(repeat);
                builder = stackBuilder.pop();
                builder.append(temp);
            } else {
                builder.append(ch);
            }
        }
        
        return builder.toString();
    }
}