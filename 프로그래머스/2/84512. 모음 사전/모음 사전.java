import java.util.*;

class Solution {
    char[] characters = new char[]{'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        return generate("").indexOf(word);
    }
    
    private List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);
        
        if (word.length() == 5) {
            return words;
        }
        
        for (char c : characters) {
            words.addAll(generate(word + c));
        }
        
        return words;
    }
}