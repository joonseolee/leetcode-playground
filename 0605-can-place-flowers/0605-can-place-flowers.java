class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length) {
            if (n == 0) {
                return true;
            }
            
            if (isAvailable(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
            
            i++;
        }
        
        if (n == 0) {
            return true;
        }
        
        return false;
    }
    
    private boolean isAvailable(int[] flowerbed, int i) {
        int length = flowerbed.length;
        if (flowerbed[i] == 1) {
            return false;
        }
        
        if (i == 0 && (length == 1 || (i + 1 < length && flowerbed[i + 1] == 0))) {
            return true;
        }
        
        if (i == 0 && i + 1 < length && flowerbed[i + 1] == 1) {
            return false;
        }
        
        if (i == length - 1 && flowerbed[i - 1] == 0) {
            return true;
        }
        
        if (i == length - 1 && flowerbed[i - 1] == 1) {
            return false;
        }
        
        if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
            return true;
        }
        
        return false;
    }
}