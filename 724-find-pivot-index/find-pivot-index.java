class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int []prefix=new int[n];
        int []postfix=new int[n];

        //prefix array 
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }

        //postfix array
        postfix[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            postfix[i]=postfix[i+1]+nums[i];
        }

        for(int i=0;i<n;i++)
        {
            //left sum
            int left=(i>0)?(prefix[i-1]):0;

            //right sum
            int right=(n-1>i)?(postfix[i+1]):0;

            //compare
            if(left==right)
            {
                return i;
            }
        }
        return -1;
    }

}