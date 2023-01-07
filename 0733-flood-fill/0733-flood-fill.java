class Solution {
    private int[] x = {0, 1, -1, 0};
    private int[] y = {1, 0, 0, -1};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int targetColor = image[sr][sc];
        boolean[][] locations = new boolean[image.length][image[0].length];
        doLogic(image, sr, sc, targetColor, color, locations);
        return image;
    }
    
    public void doLogic(int[][] image, int sr, int sc, int targetColor, int color, boolean[][] locations) {
        int xLength = image.length;
        int yLength = image[0].length;
        if (sr > -1 && sr < xLength && sc > -1 && sc < yLength && !locations[sr][sc]) {
            locations[sr][sc] = true;
            if (image[sr][sc] != targetColor) {
                return;
            }
            
            image[sr][sc] = color;
            for (int i = 0; i < 4; i++) {
                doLogic(image, sr + x[i], sc + y[i], targetColor, color, locations);
            }
        }
    }
}