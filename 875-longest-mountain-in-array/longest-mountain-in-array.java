class Solution {
    public int longestMountain(int[] arr) {
        int i=1;
        int len=arr.length;
        int ans=0;
        while(i<len-1)
        {
            //peak value
            if(arr[i-1]<arr[i] && arr[i]>arr[i+1])
            {
                int left=i;
                int right=i;

                //left len till condition is valid
                while(left>0 && arr[left-1]<arr[left])
                {
                    left--;
                }

                //right len till condition is valid
                while(right<len-1 && arr[right]>arr[right+1])
                {
                    right++;
                }

                ans=Math.max(ans,right-left+1);
                i=right;
            }
            else
            {
                i++;
            }
        }

        return ans;
    }
}