class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>set=new HashSet<>();
        for(int num:nums)
        {
            set.add(num);
        }
        int maxlen=0;
        for(int node:set)
        {
            if(!set.contains(node-1))
            {
                int curr=node;
                int len=1;
                while(set.contains(curr+1))
                {
                    curr=curr+1;
                    len++;
                }

                maxlen=Math.max(maxlen,len);
            }
        }
        return maxlen;
    }
}