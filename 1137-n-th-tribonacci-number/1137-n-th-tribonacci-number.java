import java.util.Arrays;
import java.util.List;

class Solution {
    public int tribonacci(int n) {
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        arr.add(1);
        arr.add(1);

        for (int i = 2 ; i < n ; i++) {
            int value = arr.get(i) + arr.get(i - 1) + arr.get(i - 2);
            arr.add(value);
        }

        return arr.get(n);
    }
}