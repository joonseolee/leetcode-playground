var xLocation []int = []int{0, 1, -1, 0}
var yLocation []int = []int{1, 0, 0, -1}

func solve(board [][]byte)  {
    xLength := len(board)
    yLength := len(board[0])
    visited := make([][]bool, xLength)
    for i := range visited {
     visited[i] = make([]bool, yLength)
    }
    
    for i := 0; i < xLength; i++ {
        if board[i][0] == 'O' && !visited[i][0] {
            dfs(board, visited, i, 0)
        }
        
        if board[i][yLength - 1] == 'O' && !visited[i][yLength - 1] {
            dfs(board, visited, i, yLength - 1)
        }
    }
    
    for j := 0; j < yLength; j++ {
        if board[0][j] == 'O' && !visited[0][j] {
            dfs(board, visited, 0, j)
        }
        
        if board[xLength - 1][j] == 'O' && !visited[xLength - 1][j] {
            dfs(board, visited, xLength - 1, j)
        }
    }
    
    for i := 0; i < xLength; i++ {
        for j := 0; j < yLength; j++ {
            if board[i][j] == 'O' && !visited[i][j] {
                board[i][j] = 'X'
            }
        }
    }
}

func dfs(board [][]byte, visited [][]bool, i int, j int) {
    xLength := len(board)
    yLength := len(board[0])
    visited[i][j] = true
    
    for k := 0; k < 4; k++ {
        moveX := i + xLocation[k]
        moveY := j + yLocation[k]
        if moveX >= 0 && moveX < xLength && moveY >= 0 && moveY < yLength && board[moveX][moveY] == 'O' && !visited[moveX][moveY] {
            dfs(board, visited, moveX, moveY)
        }
    }
}