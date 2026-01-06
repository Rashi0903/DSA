class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n=nums.length;
        int []w=new int[n-k+1];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(i>=k)
            {
                sum-=nums[i-k];
            }
            if(i>=k-1)
            {
                w[i-k+1]=sum;
            }
        }
        int left[]=new int[w.length];
        int best=0;
        for(int i=0;i<w.length;i++)
        {
            if(w[i]>w[best])    best=i;
            left[i]=best;
        }
        int right[]=new int[w.length];
        best=w.length-1;
        for(int i=w.length-1;i>=0;i--)
        {
            if(w[i]>=w[best])    best=i;
            right[i]=best;
        }
        int maxSum=0;
        int []ans=new int[3];
        for(int m=k;m<=w.length-k-1;m++)
        {
            int l=left[m-k];
            int r=right[m+k];
            int total=w[l]+w[r]+w[m];
            if(total>maxSum)
            {
                maxSum=total;
                ans[0]=l;
                ans[1]=m;
                ans[2]=r;
            }
        }
        return ans;
    }
}