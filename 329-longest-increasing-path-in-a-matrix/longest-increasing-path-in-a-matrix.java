class Solution {
    private final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;

        int[][] dp = new int[m][n];  // DP matrix for memoization
        int maxPath = 0;

        // Start DFS from every cell
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                maxPath = Math.max(maxPath, dfs(matrix, dp, i, j));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j) {
        // Already calculated
        if(dp[i][j] != 0) return dp[i][j];

        int maxLen = 1; // Minimum path length is 1 (cell itself)

        for(int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            // Check boundaries and increasing condition
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                maxLen = Math.max(maxLen, 1 + dfs(matrix, dp, x, y));
            }
        }

        dp[i][j] = maxLen; // Store in DP matrix
        return maxLen;
    }
}