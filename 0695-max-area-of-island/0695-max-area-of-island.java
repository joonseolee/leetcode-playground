class Solution {
    private int[] locationX = {1, 0, 0, -1};
    private int[] locationY = {0, 1, -1, 0};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, doLogic(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    
    public int doLogic(int[][] grid, int x, int y) {
        if (x > -1 && x < grid.length && y > -1 && y < grid[0].length && grid[x][y] != 0) {
            grid[x][y] = 0;
            int value = 1;
            for (int i = 0; i < 4; i++) {
                value += doLogic(grid, x + locationX[i], y + locationY[i]);
            }
            
            return value;
        }
        
        return 0;
    }
}