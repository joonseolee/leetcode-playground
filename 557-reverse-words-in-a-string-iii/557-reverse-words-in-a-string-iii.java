class Solution {
    public String reverseWords(String s) {
        List<String> words = Arrays.stream(s.split(" ")).collect(Collectors.toList());
        
        for (int i = 0 ; i < words.size() ; i++) {
            words.set(i,reverse(words.get(i)));
        }
        
        return String.join(" ", words);
    }
    
    private String reverse(String word) {
        int first = 0;
        int last = word.length() - 1;
        
        String result = "";
        
        for (int i = last ; i > -1 ; i--) {
            result += String.valueOf(word.charAt(i));
        }
        
        return result;
    }
}