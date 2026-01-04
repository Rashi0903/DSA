class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int len=nums.length;
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<len;i++)
        {
            while(!st.isEmpty() && st.peek()>nums[i] && st.size()-1+(len-i)>=k)
            {
                st.pop();
            }
            if(st.size()<k)
            {
                st.push(nums[i]);
            }
        }
        int ans[]=new int [k];
        for (int i = k - 1; i >= 0; i--) 
        {
            ans[i] = st.pop();
        }

        return ans;
    }
}