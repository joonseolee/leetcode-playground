class Solution {
    private int[] xDirection = {1, 0, 0, -1};
    private int[] yDirection = {0, 1, -1, 0};
    
    public void solve(char[][] board) {
        int xLength = board.length;
        int yLength = board[0].length;
        boolean[][] visited = new boolean[xLength][yLength];
        Stack<Location> stack = new Stack<>();
        
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    boolean isPerfect = recursion(board, visited, stack, i, j, xLength, yLength);
                    if (isPerfect) {
                        while (!stack.isEmpty()) {
                            Location location = stack.pop();
                            board[location.x][location.y] = 'X';
                        }
                    }
                    
                    stack.clear();
                }
            }
        }
    }
    
    private boolean recursion(char[][] board, boolean[][] visited, Stack<Location> stack, int i, int j, int xLength, int yLength) {
        if (i < 0 || i >= xLength || j < 0 || j >= yLength) {
            return false;
        }
        
        if (board[i][j] == 'X') {
            return true;
        }
        
        visited[i][j] = true;
        stack.add(new Location(i, j));
        
        boolean result = true;
        for (int k = 0; k < 4; k++) {
            int moveX = i + xDirection[k];
            int moveY = j + yDirection[k];
            if (0 <= moveX && xLength > moveX && 0 <= moveY && yLength > moveY && visited[i + xDirection[k]][j + yDirection[k]]) {
                continue;
            }
            
            boolean value = recursion(board, visited, stack, i + xDirection[k], j + yDirection[k], xLength, yLength);
            if (!value) {
                result = false;
            }
        }
        
        return result;
    }
    
    private static class Location {
        int x;
        int y;
        
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}