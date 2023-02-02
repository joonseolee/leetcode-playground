func uniquePaths(m int, n int) int {
    array := make([][]int, m)
    for i := 0; i < m; i++ {
        array[i] = make([]int, n)
    }
    for i := 0; i < m; i++ {
        array[i][0] = 1
    }
    
    
    for j := 0; j < n; j++ {
        array[0][j] = 1
    }
    
    for i := 1; i < m; i++ {
        for j := 1; j < n; j++ {
            array[i][j] = array[i - 1][j] + array[i][j - 1]
        }
    }
    
    return array[m -1][n -1]
}