class Solution {
    public int longestSubarray(int[] nums, int limit) {
        //dq for max
        Deque<Integer>maxdq=new LinkedList<>();

        //dq for min
        Deque<Integer>mindq=new LinkedList<>();

        int l=0;
        int maxlen=0;
        for(int r=0;r<nums.length;r++)
        {
            //input for maxdq 
            while(!maxdq.isEmpty() && nums[r]>maxdq.peekLast())
            {
                maxdq.pollLast();
            }
            maxdq.addLast(nums[r]);

            //input for mindq
            while(!mindq.isEmpty() && nums[r]<mindq.peekLast())
            {
                mindq.pollLast();
            }
            mindq.addLast(nums[r]);

            while(!maxdq.isEmpty() && !mindq.isEmpty() && (maxdq.peekFirst()-mindq.peekFirst())>limit)
            {
                if(nums[l]==maxdq.peekFirst())
                {
                    maxdq.pollFirst();
                }
                if(nums[l]==mindq.peekFirst())
                {
                    mindq.pollFirst();
                }
                l++;
            }
            maxlen=Math.max(maxlen,r-l+1);
        }
        return maxlen;
    }
}