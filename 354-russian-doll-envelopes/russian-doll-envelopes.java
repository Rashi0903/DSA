class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null || envelopes.length==0)
        {
            return 0;
        }
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0])
            {
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<envelopes.length;i++)
        {
            int height=envelopes[i][1];
            int idx=binarySearch(height,list);
            if(idx==list.size())
            {
                list.add(height);
            }
            else
            {
                list.set(idx,height);
            }
        }
        return list.size();
    }
    public int binarySearch(int height,ArrayList<Integer>list)
    {
        int left=0;
        int right=list.size();
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(list.get(mid)<height)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return left;
    }
}