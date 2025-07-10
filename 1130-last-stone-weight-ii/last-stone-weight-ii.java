class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int total=0;

        //total sum
        for(int i:stones)
        {
            total+=i;
        }

        //dp
        int [][]dp=new int [n+1][total/2+1];
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=total/2;j++)
            {
                if(stones[i-1]<=j)
                {
                    dp[i][j]=Math.max(dp[i-1][j],stones[i-1]+dp[i-1][j-stones[i-1]]);
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int max= dp[n][total/2];
        return total-2*max;
    }
}