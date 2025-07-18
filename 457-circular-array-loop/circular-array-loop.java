class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            boolean dir=nums[i]>0;
            int slow=i;
            int fast=i;
            while(true)
            {
                slow=nextIndx(nums,slow,dir);
                fast=nextIndx(nums,fast,dir);
                if(fast!=-1)
                {
                    fast=nextIndx(nums,fast,dir);
                }
                if(slow==-1 || fast==-1)
                {
                    break;
                }
                if(slow==fast)
                {
                    return true;
                }
            }
        }
        return false;
    }

    public int nextIndx(int []nums,int curr,boolean dir)
    {
        boolean currd=nums[curr]>0;
        if(currd!=dir)
        {
            return -1;
        }
        int len=nums.length;
        int next=((curr+nums[curr])%len+len)%len;
        if(next==curr)
        {
            return -1;
        }
        return next;
    }
}