class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int n=capacity.length;
        int ans=Integer.MAX_VALUE;
        int idx=-1;
        for(int i=0;i<n;i++)
        {
            if(capacity[i]>=itemSize)
            {
                int prev=ans;
                ans=Math.min(ans,capacity[i]);
                if(prev!=ans)
                {
                    idx=i;
                }
            }
        }
        return idx;
    }
}