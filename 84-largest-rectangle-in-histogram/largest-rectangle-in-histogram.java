class Solution {
    public int largestRectangleArea(int[] height) {
        int n=height.length;
        Stack<Integer>st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=n;i++)
        {
            int curr;
            if(i==n)
            {
                curr=0;
            }
            else
            {
                curr=height[i];
            }

            while(!st.isEmpty() && curr<height[st.peek()])
            {
                //pop
                int h=height[st.pop()];
                int w;
                if(st.isEmpty())
                {
                    w=i;
                }
                else
                {
                    w=i-st.peek()-1;
                }
                maxArea=Math.max(maxArea,h*w);
            }
            st.push(i);
        }
        return maxArea;
    }
}