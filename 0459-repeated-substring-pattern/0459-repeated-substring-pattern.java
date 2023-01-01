class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int[] table = makeTable(s);
        int n = s.length();
        if (table[n - 1] == 0) {
            return false;
        }
        
        int repeatCount = n - table[n - 1];
        return n % repeatCount == 0;
    }
    
    public static int[] makeTable(String pattern) {
        int length = pattern.length();
        int[] table = new int[length];
        if (length <= 1) {
            return table;
        }
        
        int index = 0;
        for (int i = 1; i < length; i++) {
            while (index > 0 && pattern.charAt(index) != pattern.charAt(i)) {
                index = table[index - 1];
            }
            
            if (pattern.charAt(index) == pattern.charAt(i)) {
                index++;
                table[i] = index;
            }
        }
        
        return table;
    }
}