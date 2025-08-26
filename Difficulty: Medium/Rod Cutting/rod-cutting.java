class Solution {
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int []dp=new int[n+1];
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                dp[j]=Math.max(dp[j],dp[j-(i+1)]+price[i]);
            }
        }
        return dp[n];
    }
}