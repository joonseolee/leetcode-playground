class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = getWidth(sizes[0]);
        int maxHeight = getHeight(sizes[0]);
        for (int[] size : sizes) {
            maxWidth = Math.max(maxWidth, getWidth(size));
            maxHeight = Math.max(maxHeight, getHeight(size));
        }
        
        return maxWidth * maxHeight;
    }
    
    private int getWidth(int[] size) {
        return size[0] > size[1] ? size[0] : size[1]; 
    }
    
    private int getHeight(int[] size) {
        return size[0] > size[1] ? size[1] : size[0];
    }
}