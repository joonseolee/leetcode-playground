class Solution {
    private int[] xDirection = {1, 0, 0, -1};
    private int[] yDirection = {0, 1, -1, 0};
    
    public void solve(char[][] board) {
        int xLength = board.length;
        int yLength = board[0].length;
        boolean[][] visited = new boolean[xLength][yLength];
        
        for (int i = 0; i < xLength; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(board, visited, i, 0);
            }
            
            if (board[i][yLength - 1] == 'O' && !visited[i][yLength - 1]) {
                dfs(board, visited, i, yLength - 1);
            }
        }
        
        for (int j = 0; j < yLength; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(board, visited, 0, j);
            }
            
            if (board[xLength - 1][j] == 'O' && !visited[xLength - 1][j]) {
                dfs(board, visited, xLength - 1, j);
            }
        }
        
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        int xLength = board.length;
        int yLength = board[0].length;
        visited[i][j] = true;
        
        for (int k = 0; k < 4; k++) {
            int moveX = i + xDirection[k];
            int moveY = j + yDirection[k];
            
            if (moveX >= 0 && moveX < xLength && moveY >= 0 && moveY < yLength 
                && board[moveX][moveY] == 'O' && !visited[moveX][moveY]) {
                dfs(board, visited, moveX, moveY);
            }
        }
    } 
}