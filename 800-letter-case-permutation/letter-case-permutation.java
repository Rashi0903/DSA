class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String>li=new ArrayList<>();
        help(s,0,li,new StringBuilder());
        return li;
    }
    public void help(String s,int idx,List<String>li,StringBuilder sb)
    {
        if(idx==s.length())
        {
            li.add(sb.toString());
            return;
        }
        char ch=s.charAt(idx);
        if(Character.isDigit(ch))
        {
            sb.append(ch);
            help(s,idx+1,li,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        else
        {
            sb.append(Character.toLowerCase(ch));
            help(s,idx+1,li,sb);
            sb.deleteCharAt(sb.length()-1);

            sb.append(Character.toUpperCase(ch));
            help(s,idx+1,li,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}