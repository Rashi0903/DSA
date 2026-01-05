class Solution {

    int[][] dp;
    int[] nums, mul;
    int n, m;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.mul = multipliers;

        n = nums.length;
        m = multipliers.length;

        dp = new int[m][m];

        // dp ko -1 se fill karo (unvisited state)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        return solve(0, 0);
    }

    int solve(int i, int l) {
        // base case
        if (i == m) return 0;

        if (dp[i][l] != Integer.MIN_VALUE)
            return dp[i][l];

        int r = n - 1 - (i - l);

        int left  = nums[l] * mul[i] + solve(i + 1, l + 1);
        int right = nums[r] * mul[i] + solve(i + 1, l);

        dp[i][l] = Math.max(left, right);
        return dp[i][l];
    }
}
