// User function Template for Java

class Solution {
    public int[] DistinctSum(int[] nums) {
        // Code here
        int totalSum=0;
        for(int n:nums)
        {
            totalSum+=n;
        }
        
        boolean []dp=new boolean[totalSum+1];
        dp[0]=true;
        for(int n:nums)
        {
            for(int sum=totalSum;sum>=n;sum--)
            {
                if(dp[sum-n])
                {
                    dp[sum]=true;
                }
            }
        }
        
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=0;i<=totalSum;i++)
        {
            if(dp[i])
            {
                res.add(i);
            }
        }
        
        int len=res.size();
        int []ans=new int[len];
        for(int i=0;i<len;i++)
        {
            ans[i]=res.get(i);
        }
        
        return ans;
    }
}