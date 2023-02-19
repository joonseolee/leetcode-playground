class Solution {
    public int reverse(int x) {
        int num = x;
        int result = 0;
        if (x < 0) {
            x = 0 - x;
        }
        
        while (x > 0) {
            if(900000000 < result) {
                return 0;
            }
            
            result = (result * 10) + (x % 10);
            x /= 10;
            if (result < 0) {
                return 0;
            }
        }
         
        if (num < 0) {
            return result * (-1);
        }
       
        return result;
    }
}