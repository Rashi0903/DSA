class Solution {
    public boolean canPartition(int[] nums) {
        int len=nums.length;
        int sum=0;
        for(int i=0;i<len;i++)
        {
            sum+=nums[i];
        }

        if(sum%2!=0)
        {
            return false;
        }

        else
        {
            int find=sum/2;
            boolean dp[][]=new boolean[len+1][find+1];
            dp[0][0]=true;
            for(int i=1;i<=len;i++)
            {
                //with any number we can make sum=0
                dp[i][0]=true;
                for(int j=1;j<=find;j++)
                {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];}
                }
            }
            return dp[len][find];
        }
    }
}