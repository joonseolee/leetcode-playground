import java.util.*;

class Solution {
    private int[] locationX = {1, 0, 0, -1};
    private int[] locationY = {0, 1, -1, 0};
    
    public int orangesRotting(int[][] grid) {
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        Queue<Node> queue = new LinkedList<>();
        List<Node> rottons = findRottenOrange(grid);
        if (rottons.size() == 0) {
            return isOnlyZero(grid) ? 0 : -1;
        }
        
        queue.addAll(rottons);
        int maxSpeed = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = node.x + locationX[i];
                int moveY = node.y + locationY[i];
                if (moveX > -1 && moveX < grid.length 
                    && moveY > -1 && moveY < grid[0].length 
                    && !visit[moveX][moveY] && grid[moveX][moveY] == 1) {
                    grid[moveX][moveY] = 2;
                    visit[moveX][moveY] = true;
                    queue.add(new Node(moveX, moveY, node.speed + 1));
                    maxSpeed = Math.max(maxSpeed, node.speed + 1);
                }
            }
        }
        
        if (!isOnlyZeroOrTwo(grid)) {
            return -1;
        }
        
        return maxSpeed;
    }
    
    private boolean isOnlyZeroOrTwo(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }       
        }
        
        return true;
    }
    
    private List<Node> findRottenOrange(int[][] grid) {
        List<Node> result = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    result.add(new Node(i, j, 0));
                }
            }       
        }
        
        return result;
    }
    
    private boolean isOnlyZero(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    return false;
                }
            }       
        }
        
        return true;
    }
    
    static class Node {
        int x;
        int y;
        int speed;
        
        public Node(int x, int y, int speed) {
            this.x = x;
            this.y = y;
            this.speed = speed;
        }
    }
}