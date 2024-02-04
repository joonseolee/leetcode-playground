class Solution {
    public String removeStars(String s) {
        char[] resultArray = new char[s.length()];
        int index = 0;

        for (char value : s.toCharArray()) {
            if (value == '*' && index > 0) {
                index--;
                continue;
            }

            resultArray[index++] = value;
        }

        return new String(resultArray, 0, index);
    }
}