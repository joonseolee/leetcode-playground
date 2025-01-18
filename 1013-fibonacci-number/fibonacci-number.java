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

        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }

        return arr[n];

        // if (arr[n] != 0) {
        //     return arr[n];
        // }

        // return arr[n] = solution(n - 1, arr) + solution(n - 2, arr);
    }
}