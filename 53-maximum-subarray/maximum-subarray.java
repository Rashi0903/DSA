class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int maxsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<len;i++)
        {
            sum+=nums[i];
            maxsum=Math.max(maxsum,sum);
            if(sum<0)
            {
                sum=0;
            }
        }
        return maxsum;
    }
}