class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                answer.append(" ");
                continue;
            }
            
            int value = ch + n;
            if (isUppercase(ch)) {
                if (value > 90) {
                    value -= 26;
                }
                
                answer.append(Character.toString(value));
                continue;
            }
            
            if (isLowercase(ch)) {
                if (value > 122) {// 123 - 25 = 98
                    value -= 26;
                }
                
                answer.append(Character.toString(value));
                continue;
            }
        }
        
        return answer.toString();
    }
    
    private boolean isUppercase(char c) {
        if (c > 64 && c < 91) {
            return true;
        }
        
        return false;
    }
    
    private boolean isLowercase(char c) {
        if (c > 96 && c < 123) {
            return true;
        }
        
        return false;
    }
}