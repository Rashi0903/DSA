class Solution {
    public long maxAlternatingSum(int[] nums) {
        long even=0;
        long odd=0;
        for(int i:nums)
        {
            long newEven=Math.max(even,odd+i);
            long newOdd=Math.max(even-i,odd);
            even=newEven;
            odd=newOdd;
        }
        return even;
    }
}