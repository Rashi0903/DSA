class Solution {
    public int dominantIndices(int[] nums) {
        int sum=0;
        for(int x:nums)
        {
            sum+=x;
        }
        int c=nums.length;
        int ans=0;
        for(int i=0;i<nums.length-1;i++)
        {
            sum=sum-nums[i];
            c=c-1;
            double avg=(double)sum/c;
            if(nums[i]>avg)
            {
                ans++;
            }
        }
        return ans;
    }
}