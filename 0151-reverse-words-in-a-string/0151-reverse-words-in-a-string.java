class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int start = 0;
        int end = words.length - 1;
        
        while (start < end) {
            String temp = words[start].trim();
            words[start] = words[end].trim();
            words[end] = temp;
            start++;
            end--;
        }
        
        return Arrays.stream(words)
                .filter(it -> it.length() != 0)
                .collect(Collectors.joining(" "));
    }
}