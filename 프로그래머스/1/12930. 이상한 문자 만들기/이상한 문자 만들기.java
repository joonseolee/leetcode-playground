class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] arr = s.toCharArray();
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!Character.isAlphabetic(arr[i])) {
                start = 0;
                answer.append(arr[i]);
                continue;
            }
            
            if (start % 2 == 0) {
                answer.append(Character.toUpperCase(arr[i]));
                start++;
                continue;
            }
            
            answer.append(Character.toLowerCase(arr[i]));
            start++;
        }
        
        return answer.toString();
    }
}