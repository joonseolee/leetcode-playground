class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        int index = 0;
        int arg = 1;

        List<String> values = new ArrayList<>();
        for (int i = 0; i < numRows ; i++) {
            values.add("");
        }

        for (char character : s.toCharArray()) {
            String element = values.get(index);
            values.set(index, element + character);

            if (index == 0) {
                arg = 1;
            }

            if (index == numRows - 1) {
                arg = -1;
            }

            index += arg;
        }

        return String.join("", values);
    }
}