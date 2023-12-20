import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] matrix = new int[n][n];
        int value = 1;
        int x = 0, y = 0;
        if (n == 0) {
            return new int[0];
        }
        if (n == 1) {
            return new int[]{1};
        }
        
        while (true) {
            if (x < 0 || y < 0 || x >= n || y >= n || matrix[x][y] != 0) {
                break;
            }
            
            // down
            while (true) {
                if (x > -1 && x < n && matrix[x][y] == 0) {
                    matrix[x][y] = value++;
                    x++;
                    continue;
                }

                break;
            }

            x--;
            y++;
            // right
            while (true) {
                if (x > -1 && y > -1 && y < n && matrix[x][y] == 0) {
                    matrix[x][y] = value++;
                    y++;
                    continue;
                }

                break;
            }

            x--;
            y -= 2;
            // up
            while (true) {
                if (matrix[x][y] == 0) {
                    matrix[x--][y--] = value++;
                    continue;
                }

                break;
            }

            x += 2;
            y++;
        }

        int[] result = new int[value - 1];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    result[index++] = matrix[i][j];
                }
            }
        }
        
        return result;
    }
}