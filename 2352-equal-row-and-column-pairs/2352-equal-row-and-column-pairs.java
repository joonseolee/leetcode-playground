class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        Map<String, Integer> m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < n; j++) {
                temp += grid[i][j] + ",";
            }

            m.put(temp, m.getOrDefault(temp, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            String temp = "";
            for (int j = 0; j < n; j++) {
                temp += grid[j][i] + ",";
            }

            if (m.containsKey(temp)) {
                count += m.get(temp);
            }
        }

        return count;
    }
}