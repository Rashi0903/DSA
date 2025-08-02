class Solution {
    public int numTilings(int n) {
        long dp[]=new long[n+1];
        int mod=1000000007;
        if(n==0) return 1;
        if(n==1) return 1;
        if(n==2) return 2;

        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3;i<=n;i++)
        {
            dp[i]=(2*dp[i-1]%mod+dp[i-3]%mod)%mod;
        }
        return (int)dp[n];
    }
}