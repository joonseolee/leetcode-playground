class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // 1D DP 배열 사용 (이전 줄을 저장)
        int[] prev = new int[n + 1];

        // 첫 번째 문자열이 비어있을 때 초기화
        for (int j = 1; j <= n; j++) {
            prev[j] = prev[j - 1] + s2.charAt(j - 1);
        }

        // 현재 행을 저장할 배열
        int[] curr = new int[n + 1];

        // DP 테이블 채우기
        for (int i = 1; i <= m; i++) {
            // 첫 번째 열 (s2가 비어 있는 경우)
            curr[0] = prev[0] + s1.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1]; // 같은 문자는 삭제할 필요 없음
                } else {
                    curr[j] = Math.min(
                        prev[j] + s1.charAt(i - 1), // s1[i-1]을 삭제
                        curr[j - 1] + s2.charAt(j - 1) // s2[j-1]을 삭제
                    );
                }
            }

            // 이전 줄을 현재 줄로 업데이트
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n];
    }
}