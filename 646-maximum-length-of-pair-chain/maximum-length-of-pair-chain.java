class Solution {
    public int findLongestChain(int[][] params) {
        if (params.length == 0) {
            return 0;
        }

        Arrays.sort(params, Comparator.comparingInt(o -> o[1]));
        int counts = 0;
        int right = -1001;

        for (int[] param : params) {
            if (right < param[0]) {
                counts++;
                right = param[1];
            }
        }
        
        return counts;
    }
}