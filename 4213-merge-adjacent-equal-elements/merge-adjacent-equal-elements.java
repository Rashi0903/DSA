class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long>ans=new ArrayList<>();
        Stack<Long>st=new Stack<>();
        for(long x:nums)
        {
            if(!st.isEmpty() && st.peek()==x)
            {
                long top=st.pop();
                long sum=top+x;
                st.push(sum);

                while(st.size()>=2)
                {
                    long last=st.pop();
                    if(st.peek()==last)
                    {
                        long prev=st.pop();
                        long s=last+prev;
                        st.push(s);
                    }
                    else
                    {
                        st.push(last);
                        break;
                    }
                }
            }
            else
            {
                st.push(x);
            }
        }
        while(!st.isEmpty())
        {
            ans.add(st.pop());
        }
        Collections.reverse(ans);
        return ans;
    }
}