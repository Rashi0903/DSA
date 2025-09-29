class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<expression.length();i++)
        {
            char op=expression.charAt(i);
            if(op=='+' || op=='-' || op=='*')
            {
                List<Integer>left=diffWaysToCompute(expression.substring(0,i));
                List<Integer>right=diffWaysToCompute(expression.substring(i+1));

                ans.addAll(combine(left,right,op));
            }
        }

        if(ans.isEmpty())
        {
            ans.add(Integer.valueOf(expression));
        }

        return ans;
    }

    public List<Integer>combine(List<Integer>left,List<Integer>right,char op)
    {
        List<Integer>res=new ArrayList<>();
        for(int a:left)
        {
            for(int b:right)
            {
                if(op=='+')         res.add(a+b);
                else if(op=='-')    res.add(a-b);
                else if(op=='*')    res.add(a*b);
            }
        }

        return res;
    }
}