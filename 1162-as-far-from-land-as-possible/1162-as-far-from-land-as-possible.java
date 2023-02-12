class Solution {
    private int[] locationX = {0, 1, -1, 0};
    private int[] locationY = {1, 0, 0, -1};
    
    public int maxDistance(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, -1);
                }
            }
        }
        
        int min = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                min = Math.min(min, grid[i][j]);
            }
        }
        
        if (min == 0) {
            return -1;
        }
        
        return min * -1;
    }
    
    private void dfs(int[][] grid, int i, int j, int distance) {
        for (int k = 0; k < 4; k++) {
            int moveX = locationX[k] + i;
            int moveY = locationY[k] + j;
            
            if (moveX > -1 && moveX < grid.length && moveY > -1 && moveY < grid[0].length) {
                if (grid[moveX][moveY] == 0 || grid[moveX][moveY] < distance) {
                    grid[moveX][moveY] = distance;
                    dfs(grid, moveX, moveY, distance - 1);
                }
            }
        }
    }
}