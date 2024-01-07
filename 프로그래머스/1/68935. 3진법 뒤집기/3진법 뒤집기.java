import java.util.*;

class Solution {
    private static final int THREE = 3;
    public int solution(int n) {
        String value = Integer.toString(n, THREE);
        String reverse = new StringBuilder(value).reverse().toString();
        return Integer.valueOf(reverse, THREE);
    }
}