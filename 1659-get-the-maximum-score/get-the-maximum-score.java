class Solution {
    static final long mod=1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        long s1=0;
        long s2=0;
        long ans=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                s1+=nums1[i];
                i++;
            }
            else if(nums1[i]>nums2[j])
            {
                s2+=nums2[j];
                j++;
            }
            else if(nums1[i]==nums2[j])
            {
                ans+=Math.max(s1,s2)+nums1[i];
                i++;
                j++;
                s1=0;
                s2=0;
            }
        }
        while(i<nums1.length)
        {
            s1+=nums1[i];
            i++;
        }
        while(j<nums2.length)
        {
            s2+=nums2[j];
            j++;
        }
        ans+=Math.max(s1,s2);

        return (int)(ans%mod);
    }
}