import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int target : moves) {
            int dollId = acquireDollId(board, target - 1);
            if (dollId == -1) {
                continue;
            }
            
            if (!stack.isEmpty() && stack.peek() == dollId) {
                stack.pop();
                result += 2;
                continue;
            }

            stack.add(dollId);
        }

        return result;
    }

    private int acquireDollId(int[][] board, int target) {
        int i = 0;
        while (i < board.length) {
            if (board[i][target] != 0) {
                int value = board[i][target];
                board[i][target] = 0;
                return value;
            }

            i++;
        }

        return -1;
    }
}