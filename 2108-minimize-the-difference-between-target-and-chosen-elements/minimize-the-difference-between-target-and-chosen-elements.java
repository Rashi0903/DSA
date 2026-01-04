class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length;
        int maxSum = m * 70;   // REAL upper bound

        boolean[][] dp = new boolean[m + 1][maxSum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            for (int s = 0; s <= maxSum; s++) {
                if (dp[i - 1][s]) {
                    for (int val : mat[i - 1]) {
                        if (s + val <= maxSum) {
                            dp[i][s + val] = true;
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int s = 0; s <= maxSum; s++) {
            if (dp[m][s]) {
                ans = Math.min(ans, Math.abs(target - s));
            }
        }
        return ans;
    }
}
