class Solution {
    public int myAtoi(String s) {
        final int length = s.length();
        boolean isNegative = false; 
        int number = 0, index = 0;

        if(length == 0)
            return 0;

        //1. Skip whitespaces
        while(index < length && s.charAt(index) == ' ')
            index++;

        //2. Check + or -
        if(index < length && (s.charAt(index) == '+' || s.charAt(index) == '-')){
            isNegative = s.charAt(index) == '-';
            index++;
        }

        //3. Translate number
        while(index < length && isDigit(s.charAt(index)))    {
            final int digit = s.charAt(index) - '0';
            if(number > (Integer.MAX_VALUE - digit) / 10)
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            number = number*10 + digit;
            index++;
        }

        return isNegative ? number*-1 : number;
    }

    boolean isDigit(char c){
        return c >= '0' && c <= '9';
    }
}