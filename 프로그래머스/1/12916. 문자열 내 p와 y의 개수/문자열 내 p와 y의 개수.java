class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'p' || c == 'P') {
                pCount++;
            }
            
            if (c == 'y' || c == 'Y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}