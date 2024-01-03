import java.util.*;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int length = 1; length <= s.length(); length++) {
            int value = compress(s, length);
            if (value < min) {
                min = value;
            }
        }
        
        return min;
    }
    
    private int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();
        
        String last = "";
        int count = 0;
        for (String token : split(source, length)) {
            if (token.equals(last)) {
                count++;
            } else {
                if (count > 1) {
                    builder.append(count);
                }
                
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        
        if (count > 1) {
            builder.append(count);
        }
        
        builder.append(last);
        
        return builder.length();
    }
    
    private List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        for (int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            if (endIndex > source.length()) {
                endIndex = source.length();
            }
            tokens.add(source.substring(startIndex, endIndex));
        }
        
        return tokens;
    }
}