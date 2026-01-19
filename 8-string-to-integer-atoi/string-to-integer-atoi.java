class Solution {
    public int myAtoi(String s) {
        if(s==null)
        {
            return 0;
        }

        //1.remove whitespace
        s=s.trim();
        if(s.length()==0)
        {
            return 0;
        }
        int i=0;

        //2.sign
        int sign=1;
        if(s.charAt(i)=='+' || s.charAt(i)=='-')
        {
            if(s.charAt(i)=='-')
            {
                sign=-1;
            }
            i++;
        }

        //3.formation of number
        long num=0;
        while(i<s.length() && Character.isDigit(s.charAt(i)))
        {
            int d=s.charAt(i)-'0';
            num=num*10+d;

            //4.overflow 
            if(sign==1 && num>Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }

            //5.underflow
            if(sign==-1 && -num<Integer.MIN_VALUE)
            {
                return Integer.MIN_VALUE;
            }

            i++;
        }
        return (int)(sign*num);
    }
}