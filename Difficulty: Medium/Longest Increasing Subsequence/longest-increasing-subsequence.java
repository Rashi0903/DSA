class Solution {
    static int lis(int nums[]) {
        // code here
        int maxlen=1;
        int n=nums.length;
        int []dp=new int[n];
        
        for(int i=0;i<n;i++)
        {
            //starting elemnt of the subsequence group ki len 1 he hogi
            dp[i]=1;
            for(int j=0;j<i;j++)
            {
                if(nums[j]<nums[i])
                {
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            maxlen=Math.max(maxlen,dp[i]);
        }
        return maxlen;
    }
}
/*
arr[] = [5, 8, 3, 7, 9, 1]
i hoga end limit
j hoga 0 to i tk traverse jo ki uus limit mai strictly increasing subsequence
ki len nikalai ga

*/