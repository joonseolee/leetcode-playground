class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        int len = Math.min(len1, len2);

        for (int i = len; i > 0; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String candidate = str1.substring(0, i);

                if (isDivisor(candidate, str1) && isDivisor(candidate, str2)) {
                    return candidate;
                }
            }
        }

        return "";
    }

    private boolean isDivisor(String candidate, String str) {
        int len = str.length();
        int subLen = candidate.length();

        if (len % subLen != 0) {
            return false;
        }

        int repetitions = len / subLen;
        StringBuilder reconstructed = new StringBuilder();

        for (int i = 0; i < repetitions; i++) {
            reconstructed.append(candidate);
        }

        return reconstructed.toString().equals(str);
    }
}