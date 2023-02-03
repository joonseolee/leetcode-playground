class Solution {
    public int minPathSum(int[][] grid) {
        int sizeX = grid.length;
        int sizeY = grid[0].length;
        
        for (int i = 1; i < sizeX; i++) {
            grid[i][0] = grid[i][0] + grid[i - 1][0];
        }
        
        for (int j = 1; j < sizeY; j++) {
            grid[0][j] = grid[0][j] + grid[0][j - 1];
        }
        
        for (int i = 1; i < sizeX; i++) {
            for (int j = 1; j < sizeY; j++) {
                int accX = grid[i][j - 1];
                int accY = grid[i - 1][j];
                grid[i][j] = Math.min(accX, accY) + grid[i][j];
            }
        }
        
        return grid[sizeX - 1][sizeY - 1];
    }
}