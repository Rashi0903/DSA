class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        int h=0;
        for(int i=0;i<len;i++)
        {
            int count=len-i;
            if(citations[i]>=count)
            {
               return count;
            }
        }
        return 0;
    }
}