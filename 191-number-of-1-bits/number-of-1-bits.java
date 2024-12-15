class Solution {
    public int hammingWeight(int n) {
        return acquire(n, 0);
    }

    private int acquire(int n, int count) {
        if (n == 0) {
            return count;
        }

        int value = n % 2;
        if (value == 1) {
            count = count + 1;
        }

        return acquire(n / 2, count);
    }
}