import java.util.*;

class Solution {
    final int[][] movements = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // up, down, right, left
    
    public int solution(String dirs) {
        Map<String, Boolean> mementos = new HashMap<>();
        int result = 0;
        int[] location = new int[]{0, 0};
        for (char dir : dirs.toCharArray()) {
            int[] move = findMove(dir);
            int newX = location[0] + move[0];
            int newY = location[1] + move[1];

            if (newX * newX > 25 || newY * newY > 25) {
                continue;
            }

            String past = String.valueOf(location[0]) + location[1];
            String current = String.valueOf(newX) + newY;

            location[0] = newX;
            location[1] = newY;
            if (mementos.get(past + current) != null || mementos.get(current + past) != null) {
                continue;
            }

            mementos.put(past + current, true);
            mementos.put(current + past, true);
            result++;
        }

        return result;
    }

    private int[] findMove(char dir) {
        switch (dir) {
            case 'U':
                return movements[0];
            case 'D':
                return movements[1];
            case 'R':
                return movements[2];
            case 'L':
                return movements[3];
            default:
                throw new RuntimeException("");
        }
    }
}