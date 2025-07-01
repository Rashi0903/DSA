class Solution {
    public int minPathSum(int[][] grid) {

        //length of row and column
        int m=grid.length;
        int n=grid[0].length;

        int dp[][]=new int[m][n];
        dp[0][0]=grid[0][0];

        //first row
        for(int i=1;i<m;i++)
        {
            dp[i][0]=grid[i][0]+dp[i-1][0];
        }

        //first column
        for(int j=1;j<n;j++)
        {
            dp[0][j]=grid[0][j]+dp[0][j-1];
        }

        //rest of the dp
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                dp[i][j]=Math.min((grid[i][j]+dp[i-1][j]),(grid[i][j]+dp[i][j-1]));
            }
        }
        return dp[m-1][n-1];
    }
}