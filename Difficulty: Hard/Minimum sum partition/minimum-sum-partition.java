// User function Template for Java

class Solution {

    public int minDifference(int arr[]) {
        // Your code goes here
        int n=arr.length;
        int total_sum=0;
        for(int i:arr)
        {
            total_sum+=i;
        }
        int target=total_sum/2;
        boolean [][]dp=new boolean[n+1][target+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++)
        {
            dp[i][0]=true;
        }
        for(int j=1;j<=target;j++)
        {
            dp[0][j]=false;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=target;j++)
            {
                boolean notTake=dp[i-1][j];
                boolean take=false;
                if(j>=arr[i-1])
                {
                    take=dp[i-1][j-arr[i-1]];
                }
                dp[i][j]=(take || notTake);
            }
        }
        
        int s1=0;
        for(int j=target;j>=0;j--)
        {
            if(dp[n][j])
            {
                s1=j;
                break;
            }
        }
        
        int s2=total_sum-s1;
        int diff=Math.abs(s1-s2);
        return diff;
    }
}
