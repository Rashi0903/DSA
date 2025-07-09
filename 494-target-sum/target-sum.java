class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }
        if(target>sum || (target+sum)%2==1 || (target + sum) < 0)
        {
            return 0;
        }
        int subset=(target+sum)/2;
        int ans=numberOfExpression(nums,subset);
        return ans;
    }
    public int numberOfExpression(int []arr,int sum)
    {
        int n=arr.length;
        int [][]dp=new int[n+1][sum+1];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}