class Solution {
    public void rotate(int[][] matrix) {
        int xLength = matrix.length;
        int yLength = matrix[0].length;
        
        for (int i = 0; i < xLength; i++) {
            for (int j = i; j < yLength; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][yLength - j - 1];
                matrix[i][yLength - j - 1] = temp;
            }
        }
    }
}