class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            
            obstacleGrid[i][0] = -1;
        }
        
        for (int j = 0; j < obstacleGrid[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            
            obstacleGrid[0][j] = -1;
        }
        
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                
                int wayY = obstacleGrid[i - 1][j] == 1 ? 0 : obstacleGrid[i - 1][j];
                int wayX = obstacleGrid[i][j - 1] == 1 ? 0 : obstacleGrid[i][j - 1];
                
                obstacleGrid[i][j] = wayY + wayX;
            }
        }
        
        int sizeX = obstacleGrid.length;
        int sizeY = obstacleGrid[0].length;
        int result = obstacleGrid[sizeX - 1][sizeY - 1] * -1;
        if (result == -1) {
            return 0;
        }
        
        return result;
    }
}