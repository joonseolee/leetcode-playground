class Solution {
    public int fib(int n) {
        int[] arr = new int[n + 1];
        return solution(n, arr);
    }

    // 1,1,2,3,5,8
    private int solution(int n, int[] arr) {
        if (n <= 1) {
            return n;
        }

        if (arr[n] != 0) {
            return arr[n];
        }

        return arr[n] = solution(n - 1, arr) + solution(n - 2, arr);
    }
}