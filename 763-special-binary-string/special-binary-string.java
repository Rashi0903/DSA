class Solution {
    public String makeLargestSpecial(String s) {
        return solve(s);
    }
    public String solve(String s)
    {
        List<String>li=new ArrayList<>();
        int start=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
            else
            {
                count--;
            }
            if(count==0)
            {
                String inner=solve(s.substring(start+1,i));
                li.add("1"+inner+"0");
                start=i+1;
            }
        }
        Collections.sort(li,Collections.reverseOrder());
        StringBuilder sb=new StringBuilder();
        for(String str:li)
        {
            sb.append(str);
        }
        return sb.toString();
    }
}