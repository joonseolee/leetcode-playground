class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = 1;
            return result;
        }
        
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int value = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                result[rowStart][i] = value++;
            }
            rowStart++;
            
            for (int j = rowStart; j <= rowEnd; j++) {
                result[j][colEnd] = value++;
            }
            colEnd--;
            
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    result[rowEnd][j] = value++;
                }
            }
            rowEnd--;

            if (colStart <= colEnd) {
                for (int j = rowEnd; j >= rowStart; j --) {
                    result[j][colStart] = value++;
                }
            }
            colStart++;
        }
        
        return result;
    }
}