class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int balloon[]=new int [n+2];
        balloon[0]=1;
        balloon[n+1]=1;
        for(int i=1;i<n+1;i++)
        {
            balloon[i]=nums[i-1];
        }
        int dp[][]=new int[n+2][n+2];
       for (int len = 2; len <= n + 1; len++) 
       {
            for (int left = 0; left <= n + 1 - len; left++) 
            {
                int right = left + len;
                for (int k = left + 1; k < right; k++) 
                {
                    dp[left][right] = Math.max(dp[left][right],balloon[left] * balloon[k] * balloon[right] + dp[left][k] + dp[k][right]);
                }
            }
        }
        return dp[0][n+1];
    }
}