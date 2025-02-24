class Solution {
    public int numDistinct(String s, String t) {
        // [  b a b g b a g]
        // [b 1   1   1    ]
        // [a   1       1  ]
        // [g       1     1]

        // [  r a b b b i t]
        // [r 1            ]
        // [a   1          ]
        // [b     1 1 1    ]
        // [b     1 1 1    ]
        // [i           1  ]
        // [t             1]

        int m = s.length(), n = t.length();
        int[] dp = new int[n + 1];

        // 빈 문자열 ""을 만드는 방법은 1개
        dp[0] = 1;

        for (int i = 1; i <= m; i++) {
            // 뒤에서부터 업데이트 (오른쪽 값이 먼저 필요하므로)
            for (int j = n; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n];
    }
}