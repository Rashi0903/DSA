class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;

        int dp[][]=new int[n][n];

        //last row
        for(int j=0;j<n;j++)
        {
            dp[n-1][j]=matrix[n-1][j];
        }

        //remaining rows
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                int down=dp[i+1][j];    //down

                int left=Integer.MAX_VALUE;
                if(j>0) //left
                {
                    left=dp[i+1][j-1];
                }

                int right=Integer.MAX_VALUE;
                if(j<n-1)   //right
                {
                    right=dp[i+1][j+1];
                }
                
                dp[i][j]=matrix[i][j]+Math.min(down,Math.min(left,right));
            }
        }

        //final ans
        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        {
            min=Math.min(min,dp[0][j]);
        }
        return min;
    }
}