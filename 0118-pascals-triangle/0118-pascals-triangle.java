class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if (numRows == 1) {
            return result;
        }

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    list.add(1);
                    continue;
                }

                if (j == i) {
                    list.add(1);
                    continue;
                }

                list.add(result.get(i - 1).get(j) + result.get(i - 1).get(j - 1));
            }

            result.add(list);
        }

        return result;
    }
}