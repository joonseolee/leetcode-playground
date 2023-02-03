func uniquePathsWithObstacles(obstacleGrid [][]int) int {
    sizeX := len(obstacleGrid)
    sizeY := len(obstacleGrid[0])
    
    for i := 0; i < sizeX; i++ {
        if obstacleGrid[i][0] == 1 {
            break
        }
        
        obstacleGrid[i][0] = -1
    }
    
    for j := 0; j < sizeY; j++ {
        if obstacleGrid[0][j] == 1 {
            break
        }
        
        obstacleGrid[0][j] = -1
    }
    
    for i := 1; i < sizeX; i++ {
        for j := 1; j < sizeY; j++ {
            if obstacleGrid[i][j] == 1 {
                continue
            }
            
            wayX := 0
            wayY := 0
            if obstacleGrid[i][j - 1] != 1 {
                wayX = obstacleGrid[i][j - 1]
            }
            
            if obstacleGrid[i - 1][j] != 1 {
                wayY = obstacleGrid[i - 1][j]
            }
            
            obstacleGrid[i][j] = wayX + wayY
        }
    }
    
    result := 0
    if obstacleGrid[sizeX - 1][sizeY - 1] != 1 {
        result = obstacleGrid[sizeX - 1][sizeY - 1] * -1
    }
    
    return result
}