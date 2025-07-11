class Solution {
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        int dp[]=new int[amount+1];
        int max=amount+1;
        for(int i=0;i<=amount;i++)
        {
            dp[i]=max;
        }
        dp[0]=0;
        for(int i=1;i<=amount;i++)
        {
            for(int j=0;j<len;j++)
            {
                if(i>=coins[j])
                {
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        if(dp[amount]>amount)
        {
            return -1;
        }
        else
        {
            return dp[amount];
        }
    }
}