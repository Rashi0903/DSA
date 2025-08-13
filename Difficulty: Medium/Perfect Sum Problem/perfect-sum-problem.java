class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int dp[][]=new int[n+1][target+1];
        
        for(int i=0;i<n;i++)
        {
            dp[i][0]=1;
        }
        
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(nums[i-1]<=j)
                {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}
/*
Input: arr[] = [2, 5, 1, 4, 3], target = 10
Output: 3
Explanation: The subsets {2, 1, 4, 3}, {5, 1, 4}, and {2, 5, 3} 
sum up to the target 10.

knap sack 

            sum---->

            i/j 0   1   2   3   4   5   6   7   8   9   10          no of elements
            0   1   0   0   0   0   0   0   0   0   0   0               |
            1   1                                                      \/
            2   1
            3   1
            4   1
            5   1

*/