/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        
        int rowStart = 0;
        int rowEnd = m - 1;
        int colStart = 0;
        int colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                if (head == null) {
                    return result;
                }
                
                result[rowStart][i] = head.val;
                head = head.next;
            }
            rowStart++;
            
            for (int j = rowStart; j <= rowEnd; j++) {
                if (head == null) {
                    return result;
                }
                
                result[j][colEnd] = head.val;
                head = head.next;
            }
            colEnd--;
            
            if (rowStart <= rowEnd) {
                for (int j = colEnd; j >= colStart; j--) {
                    if (head == null) {
                        return result;
                    }
                
                    result[rowEnd][j] = head.val;
                    head = head.next;
                }
            }
            rowEnd--;
            
            if (colStart <= colEnd) {
                for (int j = rowEnd; j >= rowStart; j--) {
                    if (head == null) {
                        return result;
                    }
                
                    result[j][colStart] = head.val;
                    head = head.next;
                }
            }
            colStart++;
        }
        
        return result;
    }
}