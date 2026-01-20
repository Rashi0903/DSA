class Solution {
    public List<String> letterCombinations(String digits) {
        List<String>ans=new ArrayList<>();
        if(digits==null || digits.length()==0)
        {
            return ans;
        }
        String []map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        find(0,digits,map,new StringBuilder(),ans);
        return ans;
    }
    public static void find(int idx,String digits,String[]map,StringBuilder path,List<String>ans)
    {
        if(idx==digits.length())
        {
            ans.add(path.toString());
            return;
        }
        String letter=map[digits.charAt(idx)-'0'];
        for(char ch:letter.toCharArray())
        {
            path.append(ch);
            find(idx+1,digits,map,path,ans);
            path.deleteCharAt(path.length()-1);
        }
    }
}