class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 1 || numRows == 1) {
            return s;
        }

        // 2차원 배열 생성
        Character[][] matrix = new Character[numRows][s.length()];

        // 2차원 배열내에 필드 초기화
        initMatrix(matrix, s, 0, 0, 0, true);

        // 2차원 배열에서 문자열 리턴
        return acquireValue(matrix);
    }

    private void initMatrix(Character[][] matrix, String value, int valueIndex, int i, int j, boolean isDown) {
        int valueSize = value.length();
        if (valueIndex >= valueSize) {
            return;
        }

        int iSize = matrix.length;

        if (i < iSize && isDown) {
            matrix[i][j] = value.charAt(valueIndex);
            initMatrix(matrix, value, valueIndex + 1, i + 1, j, true);
            return;
        }

        if (i == iSize && isDown) {
            initMatrix(matrix, value, valueIndex, i - 2, j + 1, false);
            return;
        }

        if (i > -1 && !isDown) {
            matrix[i][j] = value.charAt(valueIndex);
            initMatrix(matrix, value, valueIndex + 1, i - 1, j + 1, false);
            return;
        }

        if (i == -1) {
            initMatrix(matrix, value, valueIndex, 1, j - 1, true);
        }
    }

    private String acquireValue(Character[][] matrix) {
        StringBuilder result = new StringBuilder();
        for (Character[] row : matrix) {
            for (Character ch : row) {
                if (ch != null) {
                    result.append(ch);
                }
            }
        }

        return result.toString();
    }
}