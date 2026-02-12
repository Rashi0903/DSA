class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0;
        Deque<Integer>maxD=new ArrayDeque<>();
        Deque<Integer>minD=new ArrayDeque<>();
        int l=0;
        for(int r=0;r<nums.length;r++)
        {
            while(!maxD.isEmpty() && nums[maxD.peekLast()]<=nums[r])
            {
                maxD.pollLast();
            }
            maxD.addLast(r);
            while(!minD.isEmpty() && nums[minD.peekLast()]>=nums[r])
            {
                minD.pollLast();
            }
            minD.addLast(r);
            while(l<=r)
            {
                long maxVal=nums[maxD.peekFirst()];
                long minVal=nums[minD.peekFirst()];
                long len=r-l+1;
                long cost=(maxVal-minVal)*len;
                if(cost<=k)
                {
                    break;
                }
                if(minD.peekFirst()==l)
                {
                    minD.pollFirst();
                }
                if(maxD.peekFirst()==l)
                {
                    maxD.pollFirst();
                }
                l++;
            }
            ans+=(r-l+1);
        }
        return ans;
    }
}