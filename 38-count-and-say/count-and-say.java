class Solution {
    public String countAndSay(int n) {
        String result="1";
        for(int i=1;i<n;i++)
        {
            int c=1;
            StringBuilder str=new StringBuilder();
            for(int j=1;j<result.length();j++)
            {
                if(result.charAt(j)==result.charAt(j-1))
                {
                    c++;
                }
                else
                {
                    str.append(c).append(result.charAt(j-1));
                    c=1;
                }
            }
            str.append(c).append(result.charAt(result.length()-1));
            result=str.toString();
        }

        return result;
    }

}
/*
1211
11
*/