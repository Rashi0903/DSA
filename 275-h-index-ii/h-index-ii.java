class Solution {
    public int hIndex(int[] citations) {
        int n=citations.length;
        int low=0;
        int high=n-1;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int paperMinCite=n-mid;
            if(citations[mid]>=paperMinCite)
            {
                ans=paperMinCite;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}