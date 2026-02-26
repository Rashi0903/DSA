class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer>temp=new ArrayList<>();
        List<List<Integer>>ans=new ArrayList<>();
        backtrack(0,candidates,target,temp,ans);
        return ans;
    }
    public static void backtrack(int idx,int []c,int t,List<Integer>temp,List<List<Integer>>ans)
    {
        if(t==0)
        {
            ans.add(new ArrayList<>(temp));
            return ;
        }
        for(int i=idx;i<c.length;i++)
        {
            if(c[i]>t)
            {
                continue;
            }
            temp.add(c[i]);
            backtrack(i,c,t-c[i],temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}