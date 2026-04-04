class Solution {
    public int calculate(String s) {
       int result=0;
       int sign=1;
       int num=0;
       Stack<Integer>st=new Stack<>();
       for(int i=0;i<s.length();i++)
       {
        char ch=s.charAt(i);
        if(Character.isDigit(ch))
        {
            num=num*10+(ch-'0');
        }
        else if(ch=='+')
        {
            result+=num*sign;
            sign=1;
            num=0;
        }
        else if(ch=='-')
        {
            result+=sign*num;
            sign=-1;
            num=0;
        }
        else if(ch=='(')
        {
            st.push(result);
            st.push(sign);
            result=0;
            sign=1;
        }
        else if(ch==')')
        {
            result+=sign*num;
            num=0;
            int prevSign=st.pop();
            int prevSum=st.pop();
            result=prevSum+prevSign*result;
        }
       } 
       result+=num*sign;
       return result;
    }
}