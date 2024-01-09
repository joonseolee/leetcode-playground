class Solution {
    public boolean solution(String s) {
        return isLengthFourOrSix(s) && isNumeric(s);
    }
    
    private boolean isLengthFourOrSix(String s) {
        return s.length() == 4 || s.length() == 6;
    }
    
    private boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}