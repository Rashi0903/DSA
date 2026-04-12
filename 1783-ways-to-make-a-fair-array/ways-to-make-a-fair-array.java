class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int even[]=new int[n];
        int odd[]=new int[n];
        even[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            even[i]=even[i-1];
            odd[i]=odd[i-1];
            if(i%2==0)
            {
                even[i]+=nums[i];
            }
            else
            {
                odd[i]+=nums[i];
            }
        }
        int totalEven=even[n-1];
        int totalOdd=odd[n-1];
        int count=0;
        for(int i=0;i<n;i++)
        {
            int leftEven=(i>0)?even[i-1]:0;
            int leftOdd=(i>0)?odd[i-1]:0;

            int rightEven=totalEven-even[i];
            int rightOdd=totalOdd-odd[i];

            int newEven=leftEven+rightOdd;
            int newOdd=leftOdd+rightEven;

            if(newEven==newOdd)
            {
                count++;
            }
        }
        return count;
    }
}