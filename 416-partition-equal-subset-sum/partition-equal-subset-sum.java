class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;

        //total sum
        for(int i:nums)
        {
            sum+=i;
        }

        //agr equal partition nahi hora 
        if(sum%2!=0)
        {
            return false;
        }
        int target=sum/2;
        int n=nums.length;
        boolean dp[][]=new boolean[n+1][target+1];
        
        //base case
        dp[0][0]=true;
        for(int i=1;i<=n;i++)
        {
            dp[i][0]=true;
        }
        for(int j=1;j<=target;j++)
        {
            dp[0][j]=false;
        }

        //actual filling
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(j>=nums[i-1])
                {
                    take=dp[i-1][j-nums[i-1]];
                }
                dp[i][j]=(take || notTake);
            }
        }
        return dp[n][target];
    }
}