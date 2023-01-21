import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger one = new BigInteger(a, 2);
        BigInteger two = new BigInteger(b, 2);
        
        return one.add(two).toString(2);
    }
}