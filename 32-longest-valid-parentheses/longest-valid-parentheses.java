class Solution {
    public int longestValidParentheses(String s) {
        int n=s.length();
        int maxLen=0;
        Stack<Integer>st=new Stack<>();
        st.push(-1);
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                st.push(i);
            }
            else
            {
                st.pop();
                if(st.isEmpty())
                {
                    st.push(i);
                }
                else
                {
                    int len=i-st.peek();
                    maxLen=Math.max(len,maxLen);
                }
            }
        }
        return maxLen;
    }
}