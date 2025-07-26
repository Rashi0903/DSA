class Solution {
    public int sumOddLengthSubarrays(int[] arr) {

        int n=arr.length;
        //prefix sum array
        int []prefix=new int [n+1];
        prefix[0]=0;

        //finding the prefix sum
        for(int i=0;i<n;i++)
        {
            prefix[i+1]=prefix[i]+arr[i];
        }

        int sum=0;
        for(int l=0;l<n;l++)
        {
            for(int r=l;r<n;r++)
            {
                int len=r-l+1;  //length of the sub array
                if(len%2!=0)
                //if len is odd
                {
                    //sum of the odd subarray
                    int sub_sum=prefix[r+1]-prefix[l];
                    sum+=sub_sum;
                }
            }
        }
        return sum;
    }
}