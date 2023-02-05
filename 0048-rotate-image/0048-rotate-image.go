func rotate(matrix [][]int)  {
    xLength := len(matrix)
    yLength := len(matrix[0])
    
    for i := 0; i < xLength; i++ {
        for j := i; j < yLength; j++ {
            temp := matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    
    for i := 0; i < xLength; i++ {
        for j := 0; j < yLength / 2; j++ {
            temp := matrix[i][j]
            matrix[i][j] = matrix[i][yLength - 1 -j]
            matrix[i][yLength - 1 - j] = temp
        }
    }
}