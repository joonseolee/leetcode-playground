func generate(numRows int) [][]int {
    result := make([][]int, numRows)
    result[0] = make([]int, 1)
    result[0][0] = 1
    if numRows == 1 {
        return result
    }
    
    for i := 1; i < numRows; i++ {
        arr := make([]int, i + 1)
        
        for j := 0; j <= i; j++ {
            if j == 0 {
                arr[j] = 1
                continue
            }
            
            if j == i {
                arr[j] = 1
                continue
            }
            
            arr[j] = result[i - 1][j] + result[i - 1][j - 1]
        }
        
        result[i] = arr
    }
    
    return result
}