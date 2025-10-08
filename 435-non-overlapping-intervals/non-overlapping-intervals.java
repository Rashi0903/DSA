class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       int len=intervals.length;
       if(len==0)
       {
        return 0;
       } 

        int c=0;
       Arrays.sort(intervals,(a,b)->a[1]-b[1]);

       int prev=intervals[0][1];

       for(int i=1;i<len;i++)
       {
        int start=intervals[i][0];
        int end=intervals[i][1];

        if(prev>start)
        {
            c++;
        }
        else
        {
            prev=end;
        }
       }

       return c;
    }
}