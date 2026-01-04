class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
      int sum=0;
      int len=nums.length;
      for(int i=0;i<len;i++)
      {
        sum+=nums[i];
      } 
      if(sum%k!=0)
      {
        return false;
      } 
      int target=sum/k;
      int bucket[]=new int[k];
      Arrays.sort(nums);
      reverse(nums);
      if(nums[0]>target)
      {
        return false;
      }
      return dfs(0,bucket,nums,target);
    }
    public static void reverse(int []nums)
    {
        int l=0;
        int r=nums.length-1;
        while(l<=r)
        {
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
        }
    }
    public static boolean dfs(int idx,int[]bucket,int []nums,int target)
    {
        if(idx==nums.length)
        {
            return true;
        }
        int curr=nums[idx];
        int k=bucket.length;
        for(int i=0;i<k;i++)
        {
            if(bucket[i]+curr<=target)
            {
                bucket[i]+=curr;
                if(dfs(idx+1,bucket,nums,target))
                {
                    return true;
                }
                bucket[i]-=curr;
            }
            if(bucket[i]==0)
            {
                break;
            }
        }
        return false;
    }
}