class Solution {
    public boolean find132pattern(int[] nums) {
        int len=nums.length;
        Stack<Integer>st=new Stack<>();
        int k=Integer.MIN_VALUE;
        for(int i=len-1;i>=0;i--)
        {
            if(nums[i]<k)
            {
                return true;
            }
            while(  !st.isEmpty() && st.peek()<nums[i])
            {
                k=st.pop();
            }
          
            st.push(nums[i]);
        }
        return false;
    }
}