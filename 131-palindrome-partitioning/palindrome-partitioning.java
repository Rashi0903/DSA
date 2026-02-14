class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>curr=new ArrayList<>();
        backtrack(0,s,curr,ans);
        return ans;
    }
    public void backtrack(int start,String s,List<String>curr,List<List<String>>ans)
    {
        if(start==s.length())
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int end=start;end<s.length();end++)
        {
            if(isPalin(s,start,end))
            {
                curr.add(s.substring(start,end+1));
                backtrack(end+1,s,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isPalin(String s,int l,int r)
    {
        while(l<r)
        {
            if(s.charAt(l)!=s.charAt(r))
            {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}